package com.example.project.services;

import com.example.project.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education,String> {
    void deleteByEducationUser(String educationUser);
    List<Education> findAllByUserUsername(String username);
    Education findByEducationUser(String username);
}
