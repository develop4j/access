package com.levy.access.controller;

import com.levy.access.http.HttpResult;
import com.levy.access.model.SysMenuDO;
import com.levy.access.service.SysMenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author levy
 * @date 2020/12/27
 */
@RestController
@RequestMapping("/menu")
@Api(description = "菜单相关Api")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/getMenus")
    public HttpResult<List<SysMenuDO>> getMenus(Long parentId, Integer type) {
        return new HttpResult<>(sysMenuService.getMenus(parentId, type));
    }

}
