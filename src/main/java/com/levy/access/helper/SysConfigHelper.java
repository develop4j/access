package com.levy.access.helper;

import com.levy.access.mapper.SysConfigMapper;
import com.levy.access.model.SysConfigDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author levy
 * @date 2020/12/26
 */
@Service
public class SysConfigHelper {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    /**
     * 获取当前系统的配置信息
     *
     * @param configId
     * @return
     */
    public SysConfigDO getSysConfigById(Long configId) {
        return sysConfigMapper.selectByPrimaryKey(configId);
    }

    /**
     * 获取当前系统的配置信息
     *
     * @param creatorId
     * @return
     */
    public SysConfigDO getSysConfig(Long creatorId) {
        SysConfigDO record = new SysConfigDO();
        record.setCreatorId(creatorId);
        return sysConfigMapper.selectOne(record);
    }

    /**
     * 更新系统配置
     *
     * @param config
     */
    public void updateSysConfig(SysConfigDO config) {
        sysConfigMapper.updateByPrimaryKey(config);
    }
}
