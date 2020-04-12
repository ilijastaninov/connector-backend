package com.example.project.services;

import com.example.project.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {
    @Autowired
    ProfileServiceRepository profileServiceRepository;

    public List<Profile> getAllProfiles(String username){
        List<Profile> profiles = new ArrayList<>();
        profileServiceRepository.findAllByUserUsername(username).forEach(profiles::add);
        return profiles;
    }

    public void addProfile(Profile profile){
        profileServiceRepository.save(profile);
    }
    public Profile getProfile(String username){
        return profileServiceRepository./*findByUserProfileUsername*/findByUsernameProfile(username);
    }

    public void updateProfile(Profile profile){
        profileServiceRepository.save(profile);
    }

    public void deleteProfile(String username){
        profileServiceRepository.deleteByUsernameProfile(username);
    }
}
