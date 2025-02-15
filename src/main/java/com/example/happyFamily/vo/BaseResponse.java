package com.example.happyFamily.vo;


import com.example.happyFamily.enums.ErrorCode;

import java.io.Serializable;

/**
 * @author anbang
 * @date 2020/03/18
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -6591134951565425555L;
    protected boolean success;
    protected Integer errorCode;
    protected String errorMsg;
    protected T result;

    public BaseResponse() {
    }

    private BaseResponse(Builder<T> builder) {
        this.success = builder.success;
        this.errorCode = builder.errorCode;
        this.errorMsg = builder.errorMsg;
        this.result = builder.result;
    }

    public static Builder newSuccessResponse() {
        return new Builder().success(true);
    }

    public static Builder newFailResponse() {
        return new Builder().success(false);
    }

    public static final class Builder<T> {
        private boolean success = false;
        private Integer errorCode;
        private String errorMsg;
        private T result;

        private Builder() {
        }

        public BaseResponse build() {
            return new BaseResponse((this));
        }

        public Builder success(boolean success) {
            this.success = success;
            this.errorCode = ErrorCode.SUCCESS.getCode();
            return this;
        }

        public Builder errorCode(Integer errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder errorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public Builder result(T result) {
            this.result = result;
            return this;
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public T getResult() {
        return result;
    }

}
