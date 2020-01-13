package com.mindtree.service;

import com.mindtree.dto.User;
import com.mindtree.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Boolean validateUser(String name, String email) {
        User user =userRepository.findByNameAndEmail(name, email);
        if(Objects.nonNull(user)) {
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
