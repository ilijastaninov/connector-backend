package com.example.project.services;

import com.example.project.models.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceService {
    @Autowired
    ExpServiceRepository experienceServiceRepository;

    public void addExperience(Experience experience){
        experienceServiceRepository.save(experience);
    }
    public List<Experience> getAllExperiences(String username){
        List<Experience> experiences = new ArrayList<>();
        experienceServiceRepository.findAllByUserUsername(username).forEach(experiences::add);
        return experiences;
    }
    public Experience getExperience(String userExperience){
        return experienceServiceRepository.findByUserExperience(userExperience);
    }

    public void updateExperience(Experience experience){
        experienceServiceRepository.save(experience);
    }

    public void deleteExperience(String userExperience){
        experienceServiceRepository.deleteByUserExperience(userExperience);
    }
}
