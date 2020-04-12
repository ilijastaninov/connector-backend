package com.example.project.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Course {
    @Id
    private String courseName;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<User> users = new ArrayList<>();

    public Course() {
    }

    public Course(String courseName, List<User> users) {
        this.courseName = courseName;
        this.users = users;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
