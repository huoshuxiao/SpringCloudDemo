package com.sun.demo.springcloud.index.controller;

import com.sun.demo.springcloud.index.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search() throws Exception {
        return searchService.search();
    }

    @RequestMapping(value = "getRequestParam", method = RequestMethod.GET)
    public String getRequestParam(@RequestParam("param") String param) {
        return searchService.getRequestParam(param);
    }

    @RequestMapping(value = "getPathVariable/{path}", method = RequestMethod.GET)
    public String getPathVariable(@PathVariable("path") String path) throws Exception {
        return searchService.getPathVariable(path);
    }

    @RequestMapping(value = "postRequestBody", method = RequestMethod.POST)
    public String postRequestBody(@RequestBody String body) {
        return searchService.postRequestBody(body);
    }

    @RequestMapping(value = "fallback/{path}", method = RequestMethod.GET)
    public String fallback(@PathVariable("path") String path) throws Exception {
        return searchService.fallback(path);
    }

    @RequestMapping(value = "fallbackFactory/{path}", method = RequestMethod.GET)
    public String fallbackFactory(@PathVariable("path") String path) throws Exception {
        return searchService.fallbackFactory(path);
    }
}
