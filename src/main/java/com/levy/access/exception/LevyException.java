package com.levy.access.exception;

import com.levy.access.constants.enums.ResultEnum;
import com.levy.access.http.HttpResult;

/**
 * @author levy
 * @date 2020/12/2
 */
public class LevyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;


    public LevyException(ResultEnum result) {
        super(result.getMessage());
        this.code = result.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
