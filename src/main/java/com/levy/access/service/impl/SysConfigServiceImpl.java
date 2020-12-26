package com.levy.access.service.impl;

import com.levy.access.constants.enums.ResultEnum;
import com.levy.access.exception.AccessException;
import com.levy.access.helper.SysConfigHelper;
import com.levy.access.model.SysConfigDO;
import com.levy.access.model.SysUserDO;
import com.levy.access.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author levy
 * @date 2020/12/26
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigHelper sysConfigHelper;

    @Override
    public SysConfigDO getSysConfig(SysUserDO user) {
        if (user == null) {
            throw new AccessException(ResultEnum.NOT_LOGIN);
        }
        return sysConfigHelper.getSysConfig(user.getId());
    }

    @Override
    public void updateSysConfig(Long configId, String themeColor) {
        if (configId == null) {
            ResultEnum.PARAMETER_INVALID.setMessage(String.format(ResultEnum.PARAMETER_INVALID.getMessage(), "configId"));
            throw new AccessException(ResultEnum.PARAMETER_INVALID);
        }

        if (StringUtils.isEmpty(themeColor)) {
            ResultEnum.PARAMETER_INVALID.setMessage(String.format(ResultEnum.PARAMETER_INVALID.getMessage(), "themeColor"));
            throw new AccessException(ResultEnum.PARAMETER_INVALID);
        }
        SysConfigDO sysConfig = sysConfigHelper.getSysConfigById(configId);
        if (sysConfig == null) {
            throw new AccessException(ResultEnum.INVALID_REQUEST);
        }
        sysConfig.setValue(themeColor);
        sysConfigHelper.updateSysConfig(sysConfig);

    }
}
