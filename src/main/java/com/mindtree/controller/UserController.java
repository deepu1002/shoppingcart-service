package com.mindtree.controller;

import com.mindtree.dto.User;
import com.mindtree.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/api/users")
    public List<User> getUsers() {
        log.info("Request to get all users");
        return userService.getAllUsers();
    }

    @PostMapping("/api/users")
    public void addUser(@RequestBody User user) {
        log.info("Request to add user : " +user);
        userService.addUser(user);
    }

    @PostMapping("/api/user/validate")
    public Boolean validateUser(@RequestBody User user) {
        log.info("Request to validate user :"+ user.getUserId());
        return userService.validateUser(user.getName(), user.getEmail());
    }
}
