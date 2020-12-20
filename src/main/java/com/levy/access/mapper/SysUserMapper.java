package com.levy.access.mapper;

import com.levy.access.model.DTO.SysUserDTO;
import com.levy.access.model.SysUserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author levy
 * @date 2020/12/6
 */
@Repository
public interface SysUserMapper extends Mapper<SysUserDO> {

    /**
     * 查询用户信息
     *
     * @param name
     * @param password
     * @return
     */
    @Select("<script>" +
            "select u.id, u.name, u.nick_name, u.avatar, u.email, u.mobile, u.status, u.create_by, " +
            "u.create_time, u.last_update_by, u.last_update_time  from sys_user u " +
            "where u.name = #{name} and u.password = #{password} and u.del_flag = 0 " +
            "</script>")
    SysUserDTO getUser(@Param("name") String name, @Param("password") String password);

    /**
     * 查询所有用户信息
     *
     * @param name
     * @return
     */
    @Select("<script>" +
            "select u.id, u.name, u.nick_name, u.avatar, u.email, u.mobile, u.status, d.name as dept_name, u.create_by, u.create_time, u.last_update_by, " +
            "u.last_update_time  from sys_user u " +
            "left join sys_dept d on d.id = u.dept_id and d.del_flag = 0 " +
            "where u.del_flag = 0 " +
            "<if test='name != null and name != \"\"'>and u.name like '%${name}%'</if>" +
            "</script>")
    List<SysUserDTO> getAllUsers(@Param("name") String name);
}
