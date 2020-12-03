package com.levy.access.service;

import com.levy.access.exception.LevyException;
import com.levy.access.model.SysRoleDO;

/**
 * @author levy
 * @date 2020/12/2
 */
public interface SysRoleService {

    SysRoleDO getSysRole(Long roleId) throws LevyException;
}
