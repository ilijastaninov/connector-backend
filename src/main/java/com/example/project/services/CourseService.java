package com.example.project.services;

import com.example.project.models.Course;
import com.example.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public Course postUserToCourse(String courseName,User newUser){

        return courseRepository.findByCourseName(courseName).map(
                course -> {
                    course.getUsers().add(newUser);
                    return courseRepository.save(course);
                }
        ).orElseGet(() -> {
            return null;
        });
    }

    public List<Course> getAllCourses(){
        List<Course> courses= new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }
    public void deleteCourse(String course){
        courseRepository.deleteByCourseName(course);
    }
}
