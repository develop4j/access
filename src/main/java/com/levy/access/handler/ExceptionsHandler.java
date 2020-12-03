package com.levy.access.handler;

import com.levy.access.exception.LevyException;
import com.levy.access.http.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类
 *
 * @author levy
 * @date 2020/12/3
 */
@ControllerAdvice
public class ExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(LevyException.class)
    public HttpResult handlerException(LevyException exception) {
        return new HttpResult(exception.getCode(), exception.getMessage(), null);
    }

}
