package com.techelevator.reservations.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    public HelloController() {
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World!";
    }
}
