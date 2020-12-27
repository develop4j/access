package com.levy.access.service.impl;

import com.levy.access.helper.SysMenuHelper;
import com.levy.access.model.SysMenuDO;
import com.levy.access.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author levy
 * @date 2020/12/27
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuHelper sysMenuHelper;

    @Override
    public List<SysMenuDO> getMenus(Long parentId, Integer type) {
        List<SysMenuDO> menus = sysMenuHelper.getMenus(parentId, type);
        return menus;
    }
}
