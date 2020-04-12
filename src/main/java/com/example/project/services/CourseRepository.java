package com.example.project.services;


import com.example.project.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String> {
    void deleteByCourseName(String course);
    Optional<Course> findByCourseName(String courseName);
}
