package com.example.happyFamily.enums;

/**
 * @author anbang
 * @date 2020/03/18
 */
public enum ErrorCode {
    SUCCESS(1000000, "SUCCESS"),
    BUSINESS_EXCEPTION(2000000, "BUSINESS_EXCEPTION"),
    BAD_PARAMS(3000000, "BAD_PARAMS"),
    SIGN_INVALID(3000001, "SIGN_INVALID"),
    SYSTEM_EXCEPTION(4000000, "SYSTEM_EXCEPTION"),
    SOCKET_TIMEOUT(4000001, "SOCKET_TIMEOUT"),
    OPTIMISTIC_LOCK_EXCEPTION(4000002, "OPTIMISTIC_LOCK_EXCEPTION"),
    SERVICE_HAD_NOT_READY(4000003, "SERVICE_HAD_NOT_READY"),
    RATE_LIMIT_EXCEED_EXCEPTION(4000004, "RATE_LIMIT_EXCEED_EXCEPTION"),
    ;

    private int code;
    private String desc;

    ErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ErrorCode getByCode(int code) {
        for (ErrorCode errorCode : values()) {
            if (code == errorCode.getCode()) {
                return errorCode;
            }
        }
        throw new IllegalArgumentException("Code not Exist");
    }
}
