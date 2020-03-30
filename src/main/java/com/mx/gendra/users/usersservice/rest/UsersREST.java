package com.mx.gendra.users.usersservice.rest;

import com.mx.gendra.users.usersservice.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.mx.gendra.users.usersservice.entitys.User;

@RestController
@RequestMapping("users")
public class UsersREST {

    @Autowired
    private UsersDAO usersDAO;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users =  usersDAO.findAll();
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
        Optional<User> optionalUser = usersDAO.findById(userId);
        if(optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = usersDAO.save(user);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {
        usersDAO.deleteById(userId);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Optional<User> optionalUser = usersDAO.findById(user.getId());
        if (optionalUser.isPresent()) {
            User updateUser = optionalUser.get();
            updateUser.setName(user.getName());
            usersDAO.save(updateUser);
            return ResponseEntity.ok(updateUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
