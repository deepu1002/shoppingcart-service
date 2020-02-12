package com.mindtree.service;

import com.mindtree.dto.User;
import com.mindtree.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE , propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        log.debug("Get all users : "+ users);
        return users;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE , propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Boolean validateUser(String name, String email) {
        log.info("Validating user : "+ name);
        User user =userRepository.findByNameAndEmail(name, email);
        if(Objects.nonNull(user)) {
            log.info("User Validated successfully : "+ name);
            return true;
        }
        log.info("User validation failed : "+ name);
        return false;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE , propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public User getUserById(int id) {
        User user = userRepository.findById(id).get();
        log.debug("Get user by id : "+ id+", "+user);
        return user;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void addUser(User user) {
        log.debug("Add user : "+ user.getUserId());
        userRepository.save(user);
        log.debug("Added user successfully : "+ user.getUserId());
    }
}
