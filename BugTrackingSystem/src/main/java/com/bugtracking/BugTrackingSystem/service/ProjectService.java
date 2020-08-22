package com.bugtracking.BugTrackingSystem.service;

import com.bugtracking.BugTrackingSystem.entity.Project;
import javassist.NotFoundException;

import java.util.List;

public interface ProjectService {
    Project findByProjectName(String projectName) throws NotFoundException;
    List<Project> findAll();
    void createProject(Project project);
    void deleteProject(Project project);
}
