package com.levy.access.helper;

import com.levy.access.mapper.SysUserMapper;
import com.levy.access.model.DTO.SysUserDTO;
import com.levy.access.model.SysUserDO;
import com.levy.access.vo.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户相关信息
 *
 * @author levy
 * @date 2020/12/6
 */
@Service
public class SysUserHelper {

    @Autowired
    SysUserMapper sysUserMapper;

    public SysUserDTO getUserByNameAndPwd(String name, String pwd) {
        return sysUserMapper.getUser(name, pwd);
    }

    public SysUserDO getUserInfo(String name, String pwd) {
        SysUserDO sysUser = new SysUserDO();
        sysUser.setName(name);
        sysUser.setPassword(pwd);
        return sysUserMapper.selectOne(sysUser);
    }

    public List<SysUserDTO> getAllUsers(String name) {
        return sysUserMapper.getAllUsers(name);
    }

    public SysUserDO getUserByNameOrPassword(LoginBean loginBean) {
        SysUserDO record = new SysUserDO();
        record.setName(loginBean.getAccount());
        record.setName(loginBean.getPassword());
        return sysUserMapper.selectOne(record);
    }
}
