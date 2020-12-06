package com.levy.access.mapper;

import com.levy.access.model.SysUserDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author levy
 * @date 2020/12/6
 */
@Repository
public interface SysUserMapper extends Mapper<SysUserDO> {
}
