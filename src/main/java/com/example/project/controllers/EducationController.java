package com.example.project.controllers;

import com.example.project.models.Education;
import com.example.project.models.User;
import com.example.project.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EducationController {
    @Autowired
    EducationService educationService;

    @PostMapping("/users/{username}/educations")
    public void addEducation(@PathVariable String username,@RequestBody Education education){
        education.setUser(new User(username,"","",""));
        educationService.addEducation(education);
    }
    @GetMapping("/users/{username}/educations")
    public List<Education> getAllEducations(@PathVariable String username){
        return educationService.getAllEducations(username);
    }
    @GetMapping("/users/{username}/educations/{usernameEducation}")
    public Education getEducation(@PathVariable String usernameEducation){
        return educationService.getEducation(usernameEducation);
    }
    @PutMapping("/users/{username}/educations/{usernameEducation}")
    public void updateEducaton(@RequestBody Education education,@PathVariable String username, @PathVariable String usernameEducation){
        education.setUser(new User(username,"","",""));
        educationService.editEducation(education);
    }

    @DeleteMapping("/users/{username}/educations/{educationUser}")
    @Transactional
    public void deleteEducation(@PathVariable String educationUser){
        educationService.deleteEducation(educationUser);
    }
}
