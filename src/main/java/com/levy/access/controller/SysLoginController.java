package com.levy.access.controller;

import com.levy.access.http.HttpResult;
import com.levy.access.model.SysUserDO;
import com.levy.access.service.SysLoginService;
import com.levy.access.vo.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author levy
 * @date 2020/12/3
 */
@RestController
@RequestMapping("/login")
public class SysLoginController {

    @Autowired
    private SysLoginService sysLoginService;


    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sysLoginService.getCaptcha(request, response);
    }

    @PostMapping("/userLogin")
    public HttpResult<SysUserDO> login(@RequestBody LoginBean loginBean, HttpServletRequest request) {
        return new HttpResult(sysLoginService.login(loginBean, request));
    }

}
