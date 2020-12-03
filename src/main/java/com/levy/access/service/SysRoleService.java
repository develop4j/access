package com.levy.access.service;

import com.levy.access.exception.LevyException;
import com.levy.access.model.SysRoleDO;

import java.util.List;

/**
 * @author levy
 * @date 2020/12/2
 */
public interface SysRoleService {

    /**
     * 获取角色信息
     *
     * @param roleId
     * @return
     * @throws LevyException
     */
    SysRoleDO getSysRole(Long roleId) throws LevyException;

    /**
     * 获取所有的角色列表
     *
     * @return
     */
    List<SysRoleDO> getRoleList();
}
