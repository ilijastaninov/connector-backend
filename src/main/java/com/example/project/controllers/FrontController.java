package com.example.project.controllers;


import com.example.project.jwt.JwtUtil;
import com.example.project.jwt.models.AuthenticationRequest;
import com.example.project.jwt.models.AuthenticationResponse;
import com.example.project.models.Course;
import com.example.project.models.User;
import com.example.project.services.MyUserDetailsService;
import com.example.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FrontController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    UserService userService;


    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public void postUser(@RequestBody User user){

        userService.postUser(user);
    }
    @GetMapping("/user")
    public Optional<User> getUser(HttpServletRequest request){
        String token = request.getHeader("x-auth-token");
        String username = jwtTokenUtil.extractUsername(token);
        return userService.getByUsername(username);
        // extract username from token
        // get the authorization header
        // accept the extracted username as a path variable then get
    }
    @PutMapping("/user/{username}")
    public void updateUser(@PathVariable String username,@RequestBody User user){
          userService.updateUser(username,user);
    }
    @DeleteMapping("/user")
    @Transactional
    public void deleteUser(HttpServletRequest request){
        String token = request.getHeader("x-auth-token");
        String username = jwtTokenUtil.extractUsername(token);
        userService.deleteUser(username);
    }

    @PostMapping("/users/{username}/courses")
    public User addUserToCourse(@PathVariable String username, @RequestBody Course course){
        return userService.postUserToCourse(username,course);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
       try{
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
           );
       }catch (BadCredentialsException e){
           throw new Exception("Incorrect username or password",e);
       }
       final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
       final String jwt = jwtTokenUtil.generateToken(userDetails);
       return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }



}
