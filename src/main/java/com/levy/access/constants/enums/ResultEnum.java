package com.levy.access.constants.enums;

/**
 * @author levy
 * @date 2020/12/3
 */
public enum ResultEnum {
    SUCCESS(200, "success"),
    ERROE(400, "failed");
    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
