package com.bugtracking.BugTrackingSystem.service;

import com.bugtracking.BugTrackingSystem.entity.User;
import com.bugtracking.BugTrackingSystem.repo.UserRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User findByUserName(String userName) {
        User user = userRepo.findByUserName(userName);
        if (user == null) {
            System.out.println("User not found");
            return null;
        } else return user;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void createUser(User user) {
        User userFromDB = userRepo.findByUserName(user.getUserName());
        if (userFromDB == null) {
            userRepo.save(user);
        } else {
            System.out.println("User exist.");
        }
    }

    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
    }
}
