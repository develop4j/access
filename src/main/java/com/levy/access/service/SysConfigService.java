package com.levy.access.service;

import com.levy.access.model.SysConfigDO;
import com.levy.access.model.SysUserDO;

/**
 * @author levy
 * @date 2020/12/26
 */
public interface SysConfigService {
    /**
     * 获取系统配置
     *
     * @param user
     * @return
     */
    SysConfigDO getSysConfig(SysUserDO user);

    /**
     * 更细系统配置
     *
     * @param configId
     * @param themeColor
     */
    void updateSysConfig(Long configId, String themeColor);
}
