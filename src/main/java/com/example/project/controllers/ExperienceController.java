package com.example.project.controllers;

import com.example.project.models.Experience;
import com.example.project.models.User;
import com.example.project.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @GetMapping("/users/{username}/experiences")
    public List<Experience> getAllExperiences(@PathVariable String username){
        return experienceService.getAllExperiences(username);
    }
    @GetMapping("/users/{username}/experiences/{experienceUsername}")
    public Experience getExperience(@PathVariable String experienceUsername){
        return experienceService.getExperience(experienceUsername);
    }

    @PostMapping("/users/{username}/experiences")
    public void addExperience(@PathVariable String username, @RequestBody Experience experience){
        experience.setUser(new User(username,"","",""));
        experienceService.addExperience(experience);
    }
    @PutMapping("/users/{username}/experiences/{userExperience}")
    public void updateExperience(@RequestBody Experience experience, @PathVariable String username){
        experience.setUser(new User(username,"","",""));
        experienceService.updateExperience(experience);
    }

    @DeleteMapping("/users/{username}/experiences/{userExperience}")
    @Transactional
    public void deleteExperience(@PathVariable String userExperience){
        experienceService.deleteExperience(userExperience);
    }
}
