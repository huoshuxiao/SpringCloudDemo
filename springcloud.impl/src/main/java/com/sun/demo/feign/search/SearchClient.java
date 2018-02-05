package com.sun.demo.feign.search;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

// fallbackFactory 可接收异常
@FeignClient(value = "Search",/*fallback = SearchClientFallback.class, */fallbackFactory = SearchClientFallbackFactory.class)
@Service
public interface SearchClient {

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    String search();

    @RequestMapping(value = "getRequestParam", method = RequestMethod.GET)
    String getRequestParam(@RequestParam("param") String value);

    @RequestMapping(value = "getPathVariable/{path}", method = RequestMethod.GET)
    String getPathVariable(@PathVariable("path") String path);

    @RequestMapping(value = "postRequestBody", method = RequestMethod.POST)
    String postRequestBody(@RequestBody String body);

    @RequestMapping(value = "fallback/{path}", method = RequestMethod.GET)
    String fallback(@PathVariable("path") String path);

    @RequestMapping(value = "fallbackFactory/{path}", method = RequestMethod.GET)
    String fallbackFactory(@PathVariable("path") String path);
}
