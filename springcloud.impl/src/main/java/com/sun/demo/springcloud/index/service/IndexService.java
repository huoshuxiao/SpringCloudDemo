package com.sun.demo.springcloud.index.service;

public interface IndexService {

    String index() throws Exception;

    String getRequestParam(String value);

    String getPathVariable(String path);

    String postRequestBody(String body);
}
