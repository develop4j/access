package com.levy.access.controller;

import com.levy.access.http.HttpResult;
import com.levy.access.model.DTO.SysUserDTO;
import com.levy.access.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author levy
 * @date 2020/12/19
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户相关api")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/getAllUser")
    public HttpResult<List<SysUserDTO>> getAllUsers(String name) {
        return new HttpResult<>(sysUserService.getAllUsers(name));
    }

    @GetMapping("/getUser")
    public HttpResult<SysUserDTO> getUser(HttpServletRequest request) {
        return new HttpResult<>(sysUserService.getUser(request));
    }

}
