package com.sun.demo.springcloud.index.service;

import com.sun.demo.feign.search.SearchClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private SearchClient searchClient;

    @Override
    public String index() throws Exception {
        log.info("call index ....");
        return "Hello Spring Cloud ".concat(searchClient.search()).concat(" Feign");
    }

    @Override
    public String getRequestParam(String value) {
        log.info("call getRequestParam ....");
        return searchClient.getRequestParam(value);
    }

    @Override
    public String getPathVariable(String path) {
        log.info("call getPathVariable ....");
        Integer i;
        try {
            i = Integer.valueOf(path);
        } catch (NumberFormatException nfe) {
            return searchClient.getPathVariable(path);
        }

        if (i >=1 && i <= 5) {
            return searchClient.fallback(path);
        } else if (i >= 6 && i <= 9) {
            return searchClient.fallbackFactory(path);
        }
        return searchClient.getPathVariable(path);
    }

    @Override
    public String postRequestBody(String body) {
        log.info("call postRequestBody ....");
        return searchClient.postRequestBody(body);
    }
}
