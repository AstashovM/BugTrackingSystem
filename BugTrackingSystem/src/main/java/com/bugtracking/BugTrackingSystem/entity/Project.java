package com.bugtracking.BugTrackingSystem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROJECTS")
public class Project {

    @Id
    @Column(name = "PROJECT_NAME")
    private String projectName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Task> tasks = new ArrayList<>();

    public Project() {
    }

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}