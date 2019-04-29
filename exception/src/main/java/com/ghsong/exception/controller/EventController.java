package com.ghsong.exception.controller;

import com.ghsong.exception.exception.NullpointException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Song.gunho
 * <p>
 * Date: 2019-04-29
 */
@RestController
public class EventController {

    @GetMapping("/events")
    public String getEvents() {
        throw new NullpointException("custom exception");
    }

}
