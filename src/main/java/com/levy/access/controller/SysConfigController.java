package com.levy.access.controller;

import com.levy.access.http.HttpResult;
import com.levy.access.model.SysConfigDO;
import com.levy.access.model.SysUserDO;
import com.levy.access.service.SysConfigService;
import com.levy.access.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统配置
 *
 * @author levy
 * @date 2020/12/26
 */
@RestController
@RequestMapping("/config")
@Api(description = "系统配置相关Api")
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/getSysConfig")
    public HttpResult<SysConfigDO> getSysConfig(HttpServletRequest request) {
        SysUserDO user = sysUserService.getUserInfo(request);
        return new HttpResult<>(sysConfigService.getSysConfig(user));
    }

    @GetMapping("/updateSysConfig")
    public HttpResult updateSysConfig(@RequestParam Long configId, @RequestParam String themeColor) {
        sysConfigService.updateSysConfig(configId, themeColor);
        return new HttpResult<>();
    }
}
