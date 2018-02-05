package com.sun.demo.feign.search;

public class SearchClientFallback implements SearchClient {

    private final Throwable cause;
    public SearchClientFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public String search() {
        String value = "Hello Search API Fallback";
        return fallbackHandler(value);
    }

    @Override
    public String getRequestParam(String value) {
        return fallbackHandler(value);
    }

    @Override
    public String getPathVariable(String path) {
        return fallbackHandler(path);
    }

    @Override
    public String postRequestBody(String body) {
        return fallbackHandler(body);
    }

    @Override
    public String fallback(String path) {
        return fallbackHandler(path);
    }

    @Override
    public String fallbackFactory(String path) {
        return fallbackHandler(path);
    }

    private String fallbackHandler(String value) {
        if (this.cause instanceof Exception) {
            return cause.getMessage();
        }

        return value;
    }
}
