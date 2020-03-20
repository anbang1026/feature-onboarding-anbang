package com.example.happyFamily.aop;

import com.example.happyFamily.enums.ErrorCode;
import com.example.happyFamily.vo.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CalculatorControllerAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResponse handleAny(Throwable throwable) {
        return BaseResponse.newFailResponse()
                .errorCode(ErrorCode.SYSTEM_EXCEPTION.getCode())
                .errorMsg("System Error")
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public BaseResponse handleAny(IllegalArgumentException ex) {
        return BaseResponse.newFailResponse()
                .errorCode(ErrorCode.BAD_PARAMS.getCode())
                .errorMsg(ex.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public BaseResponse handleAny(MethodArgumentNotValidException ex) {
        return BaseResponse.newFailResponse()
                .errorCode(ErrorCode.BAD_PARAMS.getCode())
                .errorMsg(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                .build();
    }

}
