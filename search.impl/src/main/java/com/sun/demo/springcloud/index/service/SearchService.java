package com.sun.demo.springcloud.index.service;

public interface SearchService {
    String fallback(String name) throws Exception;
    String fallbackFactory(String name) throws Exception;

    String search() throws Exception;

    String getRequestParam(String value);

    String getPathVariable(String path) throws Exception;

    String postRequestBody(String body);
}
