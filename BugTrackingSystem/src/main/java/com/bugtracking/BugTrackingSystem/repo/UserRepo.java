package com.bugtracking.BugTrackingSystem.repo;

import com.bugtracking.BugTrackingSystem.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User findByUserName (String userName);

    List<User> findAll();
}
