package com.bugtracking.BugTrackingSystem.service;



import com.bugtracking.BugTrackingSystem.entity.Project;
import com.bugtracking.BugTrackingSystem.entity.Task;
import com.bugtracking.BugTrackingSystem.entity.User;

import java.util.List;

public interface TaskService {
    List<Task> findByProject(Project project);
    List<Task> findByUser(User user);
    void createTask(Task task);
    void deleteTask(Task task);
    Task findById(long id);
}
