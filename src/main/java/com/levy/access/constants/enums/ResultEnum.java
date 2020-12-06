package com.levy.access.constants.enums;

/**
 * @author levy
 * @date 2020/12/3
 */
public enum ResultEnum {
    SUCCESS(200, "success"),
    ERROE(400, "failed"),
    CAPTCHA_INVALID(400, "验证码已失效"),
    CAPTCHA_ERROR(400, "验证码不正确"),
    NOT_LOGIN(400, "用户未登录"),
    USERNAME_OR_PASSWORD_INCORRECT(400, "用户名或密码不正确");
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
