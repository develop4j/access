package com.levy.access.service;

import com.levy.access.model.DTO.SysUserDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author levy
 * @date 2020/12/19
 */
public interface SysUserService {
    /**
     * 获取当前登录的用户信息
     *
     * @param request
     * @return
     */
    SysUserDTO getUser(HttpServletRequest request);

    /**
     * 查询所有的用户信息
     *
     * @param name
     * @return
     */
    List<SysUserDTO> getAllUsers(String name);
}
