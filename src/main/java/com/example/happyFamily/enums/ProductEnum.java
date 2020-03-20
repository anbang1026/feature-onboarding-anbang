package com.example.happyFamily.enums;

import java.util.Objects;

public enum ProductEnum {
    MILK(1, "milk"),
    EGG(2, "egg"),
    ;

    private int code;
    private String name;

    ProductEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static ProductEnum getByName(String name) {
        for (ProductEnum item : ProductEnum.values()) {
            if (Objects.equals(name, item.name)) {
                return item;
            }
        }
        return null;
    }
}
