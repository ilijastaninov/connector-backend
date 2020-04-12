package com.example.project.services;

import com.example.project.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileServiceRepository extends JpaRepository<Profile,String> {
   // void deleteByUserUsernameProfileId(String username);
    void deleteByUsernameProfile(String username);
    Profile getByUserUsername(String username);
    Profile findByUsernameProfile(String username);
    public List<Profile> findAllByUserUsername(String username);
}
