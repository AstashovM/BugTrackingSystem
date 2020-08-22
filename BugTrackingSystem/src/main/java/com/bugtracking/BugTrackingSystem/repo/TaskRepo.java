package com.bugtracking.BugTrackingSystem.repo;

import com.bugtracking.BugTrackingSystem.entity.Project;
import com.bugtracking.BugTrackingSystem.entity.Task;
import com.bugtracking.BugTrackingSystem.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

    List<Task> findAllByProject(Project project);

    List<Task> findAllByUser(User user);
}
