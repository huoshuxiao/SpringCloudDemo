package com.sun.demo.springcloud.index.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public String fallback(String name) throws Exception {
        log.info("call fallback ... ");
        throw new Exception("<< fallback >>");
    }

    @Override
    public String fallbackFactory(String name) throws Exception {
        log.info("call fallbackFactory ... ");
        throw new Exception("<< fallbackFactory >>");
    }

    @Override
    public String search() throws Exception {
        log.info("call search ... ");
        return "Hello Search API";
    }

    @Override
    public String getRequestParam(String value) {
        log.info("call getRequestParam ... ");
        return value;
    }

    @Override
    public String getPathVariable(String path) throws Exception {
        log.info("call getPathVariable ... ");
        return path;
    }

    @Override
    public String postRequestBody(String body) {
        log.info("call postRequestBody ... ");
        return body;
    }
}
