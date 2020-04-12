package com.example.project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;

@Entity
public class Profile {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username_profile")
    private String usernameProfile;
    private String status;
    private String bio;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username_profile",referencedColumnName = "username_user")*/
    @ManyToOne()
    @JoinColumn(name = "username_user",nullable = false)
    @JsonBackReference
    private User user;


    public Profile(){

    }
    public Profile(String usernameProfile,String status, String bio,String userUsername) {
        this.usernameProfile = usernameProfile;
        this.status = status;
        this.bio = bio;
        this.user = new User(userUsername,"","","");
    }
    /*public String getUsername_profile() {
        return username_profile;
    }

    public void setUsername_profile(String username_profile) {
        this.username_profile = username_profile;
    }*/

    public String getUsernameProfile() {
        return usernameProfile;
    }

    public void setUsernameProfile(String usernameProfile) {
        this.usernameProfile = usernameProfile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   /* public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


}
