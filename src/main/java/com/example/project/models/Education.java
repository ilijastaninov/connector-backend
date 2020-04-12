package com.example.project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Education {
    @Id
    @Column(name = "educationUser")
    private String educationUser;
    private String degree;
    @Column(name = "dateFrom")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date from;
    @Column(name = "dateTo")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date to;
    private Boolean current = false;
    private String description;

    @ManyToOne
    @JoinColumn(name = "username_user",nullable = false)
    @JsonBackReference
    private User user;

    public Education() {
    }

    public Education(String educationUser, String degree, Date from, Date to, Boolean current, String description,User user) {
        this.educationUser = educationUser;
        this.degree = degree;
        this.from = from;
        this.to = to;
        this.current = current;
        this.description = description;
        this.user = user;
    }

    public String getEducationUser() {
        return educationUser;
    }

    public void setEducationUser(String educationUser) {
        this.educationUser = educationUser;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
