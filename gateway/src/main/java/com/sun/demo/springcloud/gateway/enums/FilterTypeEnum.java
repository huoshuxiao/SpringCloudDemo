package com.sun.demo.springcloud.gateway.enums;

// Zuul filter Type enums(pre、route、post、error)
public enum FilterTypeEnum {

    PRE("pre"),
    ROUTE("route"),
    POST("post"),
    ERROR("error");

    private String filterType;

    FilterTypeEnum(String filterType) {
        this.filterType = filterType;
    }

    public String getValue() {
        return this.filterType;
    }
}