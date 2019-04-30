package com.ghsong.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Song.gunho
 * <p>
 * Date: 2019-04-30
 */
@RestController
public class TestController {

    @GetMapping("/api")
    public String getEvent() {
        return "events";
    }

    @GetMapping("/api/user")
    public String getUser() {
        return "user";
    }

}
