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

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

//    @GetMapping("/user/id/{id}")
//    public User getUserById(int id) {
//        return userService.getUserById(id);
//    }

    @GetMapping("/user/{name}/{email}")
    public User getUserByNameAndEmail(String name, String email) {
        return userService.getUserByNameAndEmail(name, email);
    }
}
