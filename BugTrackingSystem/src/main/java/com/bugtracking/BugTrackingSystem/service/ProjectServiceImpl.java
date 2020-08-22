package com.bugtracking.BugTrackingSystem.service;

import com.bugtracking.BugTrackingSystem.entity.Project;
import com.bugtracking.BugTrackingSystem.repo.ProjectRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepo projectRepo;

    @Override
    public Project findByProjectName(String projectName) throws NotFoundException {
        Project project = projectRepo.findByProjectName(projectName);
        if (project != null) {
            return  project;
        } else {
            System.out.println("Project not found");
            return null;
        }
    }

    @Override
    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    @Override
    public void createProject(Project project) {
        Project projectFromDB = projectRepo.findByProjectName(project.getProjectName());
        if (projectFromDB == null) {
            projectRepo.save(project);
        } else {
            System.out.println("Project exist.");
        }
    }

    @Override
    public void deleteProject(Project project) {
        projectRepo.delete(project);
    }
}
