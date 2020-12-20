package com.levy.access.interceptor;

import com.levy.access.constants.enums.ResultEnum;
import com.levy.access.exception.AccessException;
import com.levy.access.helper.SysUserHelper;
import com.levy.access.model.DTO.SysUserDTO;
import com.levy.access.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截验证
 *
 * @author levy
 * @date 2020/12/6
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final String REQUEST_METHOD_OPTION = "OPTIONS";

    @Autowired
    private SysUserHelper sysUserHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            // 获取登录信息
            String token = (String) request.getSession().getAttribute("token");
            if (StringUtil.isEmpty(token)) {
                token = request.getHeader("token");
            }
            String method = request.getMethod();
            // 获取请求的地址
            String url = request.getRequestURL().toString();
            // OPTIONS请求类型直接返回不处理
            if (REQUEST_METHOD_OPTION.equals(method) || url.endsWith("/access/")) {
                return true;
            }
            if (StringUtil.isEmpty(token)) {
                throw new AccessException(ResultEnum.NOT_LOGIN);
            }
            // 进行解密
            String des = TokenUtils.decryptDes(TokenUtils.KEY, token);
            // 根据解密后的内容获取用户信息
            String[] split = des.split("-");
            SysUserDTO user = sysUserHelper.getUserByNameAndPwd(split[0], split[1]);
            if (user == null) {
                throw new AccessException(ResultEnum.NOT_LOGIN);
            }
        } catch (Exception e) {
            throw new AccessException(ResultEnum.NOT_LOGIN);
        }
        return true;
    }
}
