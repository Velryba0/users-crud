package com.mx.gendra.users.usersservice.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.mx.gendra.users.usersservice.entitys.User;

@RestController
@RequestMapping("users")
public class UsersREST {

    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        return null;
    }

    //@GetMapping
    public String hello() {
        return "Hello World!!";
    }
}
