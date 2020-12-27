package com.levy.access.mapper;

import com.levy.access.model.SysMenuDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author levy
 * @date 2020/12/27
 */
@Repository
public interface SysMenuMapper extends Mapper<SysMenuDO> {

    /**
     * 获取菜单
     *
     * @param parentId
     * @param type     菜单类型
     * @return
     */
    @Select("<script>" +
            "SELECT DISTINCT * FROM sys_menu WHERE del_flag = 0 " +
            "<if test = 'parentId != null'> AND parent_id = #{parentId} </if> " +
            "<if test = 'type != null'> AND type = #{type} </if> " +
            "ORDER BY id DESC " +
            "</script>")
    List<SysMenuDO> getMenus(@Param("parentId") Long parentId, @Param("type") Integer type);

}
