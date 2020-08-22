package com.bugtracking.BugTrackingSystem.service;

import com.bugtracking.BugTrackingSystem.entity.Project;
import com.bugtracking.BugTrackingSystem.entity.Task;
import com.bugtracking.BugTrackingSystem.entity.User;
import com.bugtracking.BugTrackingSystem.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepo taskRepo;


    @Override
    public List<Task> findByProject(Project project) {
        return taskRepo.findAllByProject(project);
    }

    @Override
    public List<Task> findByUser(User user) {
        return taskRepo.findAllByUser(user);
    }

    @Override
    public void createTask(Task task) {
        taskRepo.save(task);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepo.delete(task);
    }

    @Override
    public Task findById(long id) {
        if (taskRepo.existsById(id)) {
            return taskRepo.findById(id).get();
        } else {
            System.out.println("Task not found");
            return null;
        }
    }
}
