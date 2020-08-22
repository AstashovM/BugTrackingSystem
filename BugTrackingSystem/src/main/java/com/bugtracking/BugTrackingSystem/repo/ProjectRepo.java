package com.bugtracking.BugTrackingSystem.repo;

import com.bugtracking.BugTrackingSystem.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {

    Project findByProjectName(String projectName);

    List<Project> findAll();
}