package com.levy.access.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.levy.access.constants.enums.ResultEnum;

/**
 * 封装http请求结果
 *
 * @author levy
 * @date 2020/12/3
 */
public class HttpResult<T> {

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
     * 如果为空则不返回
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public HttpResult() {
        this(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    public HttpResult(T data) {
        this(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public HttpResult(int code, String message, T data) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
