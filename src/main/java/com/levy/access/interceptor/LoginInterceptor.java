package com.levy.access.interceptor;

import com.levy.access.constants.enums.ResultEnum;
import com.levy.access.exception.AccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 获取登录信息
        String token = (String) request.getSession().getAttribute("token");
        // 获取请求的地址
        String url = request.getRequestURL().toString();
        if (null != token || url.endsWith("/access/")) {
            return true;
        }
        throw new AccessException(ResultEnum.NOT_LOGIN);
    }

}
