package com.mindtree.service;

import com.mindtree.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    void addUser(User user);
    User getUserByNameAndEmail(String name, String email);
}
