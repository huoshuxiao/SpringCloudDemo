package com.sun.demo.springcloud.index.controller;

import com.sun.demo.springcloud.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        return indexService.index();
    }

    @RequestMapping(value = "getRequestParam", method = RequestMethod.GET)
    public String getRequestParam(@RequestParam("param") String param) {
        return indexService.getRequestParam(param);
    }

    @RequestMapping(value = "getPathVariable/{path}", method = RequestMethod.GET)
    public String getPathVariable(@PathVariable("path") String path) {
        return indexService.getPathVariable(path);
    }

    @RequestMapping(value = "postRequestBody", method = RequestMethod.POST)
    public String postRequestBody(@RequestBody String body) {
        return indexService.postRequestBody(body);
    }

    @RequestMapping(value = "fallback/{path}", method = RequestMethod.GET)
    public String fallback(@PathVariable("path") String path) {
        return indexService.getPathVariable(path);
    }

    @RequestMapping(value = "fallbackFactory/{path}", method = RequestMethod.GET)
    public String fallbackFactory(@PathVariable("path") String path) {
        return indexService.getPathVariable(path);
    }
}
