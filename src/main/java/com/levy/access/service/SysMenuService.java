package com.levy.access.service;

import com.levy.access.model.SysMenuDO;

import java.util.List;

/**
 * @author levy
 * @date 2020/12/27
 */
public interface SysMenuService {

    /**
     * 菜单权限
     *
     * @param parentId
     * @param type
     * @return
     */
    List<SysMenuDO> getMenus(Long parentId, Integer type);
}
