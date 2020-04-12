package com.example.project.services;

import com.example.project.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpServiceRepository extends JpaRepository<Experience,String> {
    void deleteByUserExperience(String userExperience);
    List<Experience> findAllByUserUsername(String username);
    Experience findByUserExperience(String username);
}
