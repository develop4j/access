package com.levy.access.service.impl;

import com.levy.access.constants.enums.ResultEnum;
import com.levy.access.exception.LevyException;
import com.levy.access.helper.SysRoleHelper;
import com.levy.access.model.SysRoleDO;
import com.levy.access.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author levy
 * @date 2020/12/2
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    SysRoleHelper sysRoleHelper;

    @Override
    public SysRoleDO getSysRole(Long roleId) throws LevyException {
        SysRoleDO role = sysRoleHelper.getSysRole(roleId);
        if (role == null) {
            throw new LevyException(ResultEnum.ERROE);
        }
        return role;
    }

    @Override
    public List<SysRoleDO> getRoleList() {
        return sysRoleHelper.getRoleList();
    }
}
