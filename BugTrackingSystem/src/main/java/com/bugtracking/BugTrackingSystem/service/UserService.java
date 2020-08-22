package com.bugtracking.BugTrackingSystem.service;

import com.bugtracking.BugTrackingSystem.entity.User;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {

    User findByUserName(String userName) throws NotFoundException;
    List<User> findAll();
    void createUser(User user);
    void deleteUser(User user);
}
