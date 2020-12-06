package com.levy.access.service;

import com.levy.access.model.SysUserDO;
import com.levy.access.vo.LoginBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author levy
 * @date 2020/12/4
 */
public interface SysLoginService {

    /**
     * 获取验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 登录信息
     *
     * @param loginBean
     * @param request
     */
    SysUserDO login(LoginBean loginBean, HttpServletRequest request);
}
