package com.example.project.services;

import com.example.project.models.Course;
import com.example.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@EnableAsync(proxyTargetClass = true)
public class UserService {
    @Autowired
    UserServiceRepository userServiceRepository;

    public void postUser(User user){
        userServiceRepository.save(user);
    }
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userServiceRepository.findAll().forEach(users::add);
        return users;
    }
    public Optional<User> getUser(String username){
        return userServiceRepository.getByUsername(username);
    }
    public void updateUser(String username, User user){
        userServiceRepository.save(user);
    }
    public Optional<User> getByUsername(String username){
        return userServiceRepository.getByUsername(username);
    }
    public void deleteUser(String username){
        userServiceRepository.deleteByUsername(username);
    }

    public User postUserToCourse(String username, Course newCourse){

        return userServiceRepository.getByUsername(username).map(
                user -> {
                    user.getCourses().add(newCourse);
                    return userServiceRepository.save(user);
                }
        ).orElseGet(() -> {
            return null;
        });
    }
}
