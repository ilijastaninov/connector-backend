package com.example.project.models;


import com.fasterxml.jackson.annotation.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {
    @Id
    @Column(name = "username_user",unique = true)
    private String username;
    private String password;
    private String name;
    private String email;
    private Boolean active = true;

    /*@OneToOne(mappedBy = "user")*/
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Profile>  profile;

   /* @OneToMany
    private Profile profileProfile;*/

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Experience> experiences;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Education> educations;

    /*@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(name = "course_user",
            joinColumns = @JoinColumn(name = "course_courseName"),
            inverseJoinColumns = @JoinColumn(name = "user_username")
    )*/
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "user_course",
            joinColumns = @JoinColumn(name = "user_username"),
            inverseJoinColumns = @JoinColumn(name = "course_courseName")
    )
    private Set<Course> courses = new HashSet<>();

    public User(){}
    public User(String username,String password, String name,String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }


    public List<Profile>  getProfile() {
        return profile;
    }

    public void setProfile(List<Profile>  profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
