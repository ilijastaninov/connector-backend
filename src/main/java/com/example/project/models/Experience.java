package com.example.project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Experience {
    @Id
    @Column(name = "user_experience")
    private String userExperience;
    private String title;
    private String company;
    @Column(name = "dateFrom")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date from;
    @Column(name = "dateTo")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date to;
    private Boolean current = false;

    @ManyToOne
    @JoinColumn(name = "username_user",nullable = false)
    @JsonBackReference
    private User user;

    public Experience() {
    }

    public Experience(String title, String company, Date from, Date to, Boolean current, User user) {
        this.title = title;
        this.company = company;
        this.from = from;
        this.to = to;
        this.current = current;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(String userExperience) {
        this.userExperience = userExperience;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }
}
