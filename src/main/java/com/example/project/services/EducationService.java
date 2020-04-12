package com.example.project.services;

import com.example.project.models.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EducationService {
    @Autowired
    EducationRepository educationRepository;

    public void addEducation(Education education){
        educationRepository.save(education);
    }
    public List<Education> getAllEducations(String username){
        List<Education> educationList = new ArrayList<>();
        educationRepository.findAllByUserUsername(username).forEach(educationList::add);
        return educationList;
    }
    public Education getEducation(String usernameEducation){
        return educationRepository.findByEducationUser(usernameEducation);
    }
    public void editEducation(Education education){
        educationRepository.save(education);
    }

    public void deleteEducation(String educationUser){
        educationRepository.deleteByEducationUser(educationUser);
    }
}
