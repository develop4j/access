package com.levy.access.controller;

import com.levy.access.exception.LevyException;
import com.levy.access.http.HttpResult;
import com.levy.access.service.SysRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author levy
 * @date 2020/12/2
 */
@RestController
@RequestMapping("/role")
@Api(description = "角色相关信息")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;


    @GetMapping("/getRole")
    public HttpResult getSysRole(Long roleId) {
        return new HttpResult(sysRoleService.getSysRole(roleId));
    }
}