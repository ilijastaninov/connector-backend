package com.example.project.services;

import com.example.project.models.MyUserDetails;
import com.example.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserServiceRepository userServiceRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userServiceRepository.getByUsername(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+ userName));
        return user.map(MyUserDetails::new).get();
    }
}
