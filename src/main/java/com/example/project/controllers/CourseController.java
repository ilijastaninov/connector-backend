package com.example.project.controllers;

import com.example.project.models.Course;
import com.example.project.models.User;
import com.example.project.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/courses")
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
    @DeleteMapping("/course/{courseName}")
    @Transactional
    public void deleteCourse(@PathVariable String courseName){
        courseService.deleteCourse(courseName);
    }

    @PostMapping("/courses/{courseName}/users")
    public Course addUser(@PathVariable String courseName, @RequestBody User user){
        return courseService.postUserToCourse(courseName,user);
    }
}
