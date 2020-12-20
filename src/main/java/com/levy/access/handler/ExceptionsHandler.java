package com.levy.access.handler;

import com.levy.access.exception.AccessException;
import com.levy.access.http.HttpResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理类
 *
 * @author levy
 * @date 2020/12/3
 */
@RestControllerAdvice
public class ExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(value = AccessException.class)
    public HttpResult handlerException(AccessException exception) {
        exception.printStackTrace();
        return new HttpResult(exception.getCode(), exception.getMessage(), null);
    }

}
