package com.levy.access.helper;

import com.levy.access.mapper.SysRoleMapper;
import com.levy.access.model.SysRoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author levy
 * @date 2020/12/2
 */

@Service
public class SysRoleHelper {

    @Autowired
    SysRoleMapper sysRoleMapper;

    public SysRoleDO getSysRole(Long roleId) {
        return sysRoleMapper.selectByPrimaryKey(roleId);
    }

    public List<SysRoleDO> getRoleList() {
        return sysRoleMapper.selectAll();
    }
}
