package com.example.project.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Course {
    @Id
    private String courseName;

    /*@ManyToMany(mappedBy = "courses")
    @JsonIgnore*/
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(name = "course_user",
            joinColumns = @JoinColumn(name = "course_courseName"),
            inverseJoinColumns = @JoinColumn(name = "user_username")
    )
    private List<User> users = new ArrayList<>();

    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;
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
