package com.bugtracking.BugTrackingSystem.entity;

import javax.persistence.*;

@Entity
@Table (name = "TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "project")
    private Project project;

    @Column(name = "THEME")
    private String theme;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PRIORITY")
    private String priority;

    @ManyToOne
    @JoinColumn(name = "USER")
    private User user;

    @Column(name = "DESCRIPTION")
    private String description;

    public Task() {
    }

    public Task(Project project, String theme, String type, String priority, User user, String description) {
        this.project = project;
        this.theme = theme;
        this.type = type;
        this.priority = priority;
        this.user = user;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void getByUser() {
        if (user != null) {
            System.out.println("Id: " + id);
            System.out.println("Project: " + project.getProjectName());
            System.out.println("Theme: " + theme);
            System.out.println("Type: " + type);
            System.out.println("Priority: " + priority);
            System.out.println("Description: " + description + "\n");
        }
    }

    public void getByProject() {
        if (project != null) {
            System.out.println("Id: " + id);
            System.out.println("Theme: " + theme);
            System.out.println("Type: " + type);
            System.out.println("Priority: " + priority);
            System.out.println("User: " + user.getUserName());
            System.out.println("Description: " + description + "\n");
        }
    }
}

