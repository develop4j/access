package com.levy.access.utils;

import com.levy.access.constants.enums.ResultEnum;
import com.levy.access.exception.AccessException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 参数校验工具类
 *
 * @author levy
 * @date 2020/12/26
 */
public class ParameterUtils {

    /**
     * 校验参数
     *
     * @param params
     * @param name
     * @return
     */
    public static Boolean checkParams(Object params, String name) {
        if (params instanceof String) {
            ResultEnum.PARAMETER_INVALID.setMessage(String.format(ResultEnum.PARAMETER_INVALID.getMessage(), name));
            if (StringUtils.isEmpty(params)) {
                throw new AccessException(ResultEnum.PARAMETER_INVALID);
            }
        } else if (params instanceof List) {
            if (CollectionUtils.isEmpty((List) params)) {
                throw new AccessException(ResultEnum.PARAMETER_INVALID);
            }
        } else if (params instanceof Long) {
            if ((long) params <             0) {
                throw new AccessException(ResultEnum.PARAMETER_INVALID);
            }
        } else if (params instanceof Integer) {
            ResultEnum.PARAMETER_INVALID.setMessage(String.format(ResultEnum.PARAMETER_INVALID.getMessage(), name));
            if ( params == null || (int) params < 0) {
                throw new AccessException(ResultEnum.PARAMETER_INVALID);
            }
        } else {
            if (params == null) {
                throw new AccessException(ResultEnum.PARAMETER_INVALID);
            }
        }
        return true;
    }
}
