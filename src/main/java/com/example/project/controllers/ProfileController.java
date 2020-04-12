package com.example.project.controllers;

import com.example.project.jwt.JwtUtil;
import com.example.project.jwt.filters.JwtRequestFilter;
import com.example.project.models.Profile;
import com.example.project.models.User;
import com.example.project.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @Autowired
    JwtUtil jwtTokenUtil;

    @GetMapping("/users/{username}/profiles")
    public List<Profile> getAllProfiles(@PathVariable String username){
        return profileService.getAllProfiles(username);
    }
    @GetMapping("/users/{username}/profiles/{profileUsername}")
    public Profile getProfile(@PathVariable String profileUsername, @PathVariable String username){
        Profile profile = profileService.getProfile(profileUsername);
        return profile;
    }

    @PostMapping("/users/{username}/profiles")
    public void addProfile(@PathVariable String username,@RequestBody Profile profile){
        profile.setUser(new User(username,"","",""));
        profileService.addProfile(profile);
    }

    @PutMapping("/users/{username}/profile/{profileUsername}")
    public void updateProfile(@RequestBody Profile profile,@PathVariable String username,@PathVariable String profileUsername){
        profile.setUser(new User(username,"","",""));
        profileService.updateProfile(profile);
    }

    @DeleteMapping("/users/{username}/profile/{profileUsername}")
    @Transactional
    public void deleteProfile(@PathVariable String username,@PathVariable String profileUsername){
        profileService.deleteProfile(profileUsername);
    }
}
