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
    USERNAME_OR_PASSWORD_INCORRECT(60004, "用户名或密码不正确"),
    /**
     * 参数校验失败
     */
    PARAMETER_INVALID(60005, "参数[%s]不能为空"),
    /**
     * 无效请求
     */
    INVALID_REQUEST(60006, "无效的请求");

    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
