package com.bugtracking.BugTrackingSystem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_NAME")
    private String userName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
