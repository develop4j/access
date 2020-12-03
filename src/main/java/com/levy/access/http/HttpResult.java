package com.levy.access.http;

import com.levy.access.constants.enums.ResultEnum;

/**
 * 封装http请求结果
 *
 * @author levy
 * @date 2020/12/3
 */
public class HttpResult {

    /**
     * 请求返回的编码
     */
    private int code;
    /**
     * 请求返回的信息
     */
    private String message;
    /**
     * 请求返回的内容
     */
    private Object data;

    public HttpResult() {
        this(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    public HttpResult(Object data) {
        this(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public HttpResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
