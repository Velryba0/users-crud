package com.mx.gendra.users.usersservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UsersREST {

    @GetMapping
    public String hello() {
        return "Hello Fucking World!!";
    }
}
