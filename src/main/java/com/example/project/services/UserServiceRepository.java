package com.example.project.services;

import com.example.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserServiceRepository extends JpaRepository<User,String> {
    Optional<User> getByUsername(String username);
    void deleteByUsername(String username);
}
