package com.levy.access.helper;

import com.levy.access.mapper.SysMenuMapper;
import com.levy.access.model.SysMenuDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统菜单
 *
 * @author levy
 * @date 2020/12/27
 */
@Service
public class SysMenuHelper {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 获取菜单信息
     *
     * @param parentId
     * @param type
     * @return
     */
    public List<SysMenuDO> getMenus(Long parentId, Integer type) {
        return sysMenuMapper.getMenus(parentId, type);
    }

}
