package com.levy.access.constants.enums;

/**
 * @author levy
 * @date 2020/12/3
 */
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     * 失败
     */
    ERROE(400, "failed"),
    /**
     * 验证码已失效
     */
    CAPTCHA_INVALID(60001, "验证码已失效"),
    /**
     * 验证码不正确
     */
    CAPTCHA_ERROR(60002, "验证码不正确"),
    /**
     * 用户未登录
     */
    NOT_LOGIN(60003, "用户未登录"),
    /**
     * 用户名或密码不正确
     */
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
