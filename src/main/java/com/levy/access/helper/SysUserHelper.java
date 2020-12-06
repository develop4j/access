package com.levy.access.helper;

import com.levy.access.mapper.SysUserMapper;
import com.levy.access.model.SysUserDO;
import com.levy.access.vo.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

    public SysUserDO getUserByNameOrPassword(LoginBean loginBean) {
        SysUserDO record = new SysUserDO();
        record.setName(loginBean.getAccount());
        record.setName(loginBean.getPassword());
        return sysUserMapper.selectOne(record);
    }
}
