package com.sun.demo.springcloud.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, List<String>> getUserInfo(@PathVariable("id") String id) {
        log.debug("call user: " + id + "%%%%%%%%%%%%%%");
        Map<String, List<String>> map = new HashMap<>();
        List<String> user = new ArrayList<>();
        user.add(id);
        map.put(id, user);
        return map;
    }
}
