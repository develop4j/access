package com.levy.access.service.impl;

import com.levy.access.constants.enums.ResultEnum;
import com.levy.access.exception.AccessException;
import com.levy.access.helper.SysUserHelper;
import com.levy.access.model.DTO.SysUserDTO;
import com.levy.access.service.SysUserService;
import com.levy.access.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author levy
 * @date 2020/12/19
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserHelper sysUserHelper;

    @Override
    public SysUserDTO getUser(HttpServletRequest request) {
        // 获取token
        String token = (String) request.getSession().getAttribute("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getHeader("token");
        }
        if (StringUtils.isEmpty(token)) {
            throw new AccessException(ResultEnum.NOT_LOGIN);
        }
        // 进行解密
        String des = TokenUtils.decryptDes(TokenUtils.KEY, token);
        // 根据解密后的内容获取用户信息
        String[] split = des.split("-");
        SysUserDTO user = sysUserHelper.getUserByNameAndPwd(split[0], split[1]);
        return user;
    }

    @Override
    public List<SysUserDTO> getAllUsers(String name) {
        List<SysUserDTO> allUsers = sysUserHelper.getAllUsers(name);
        return allUsers;
    }
}
