package com.mindtree.controller;

import com.mindtree.dto.User;
import com.mindtree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/api/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping("/api/user/validate")
    public Boolean validateUser(@RequestBody User user) {
        return userService.validateUser(user.getName(), user.getEmail());
    }
}
