package com.mindtree.repository;

import com.mindtree.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNameAndEmail(String name, String email);
}
