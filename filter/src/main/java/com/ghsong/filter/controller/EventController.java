package com.ghsong.filter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Song.gunho
 * <p>
 * Date: 2019-04-30
 */
@RestController
@Slf4j
public class EventController {

    @GetMapping("/event")
    public String getEvent() {
        log.debug("Get /event ::");
        return "events";
    }

    @GetMapping("/event/user")
    public String getUser() {
        log.debug("Get /event/user ::");
        return "user";
    }

}
