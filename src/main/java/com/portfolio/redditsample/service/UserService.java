package com.portfolio.redditsample.service;

import com.portfolio.redditsample.model.User;
import com.portfolio.redditsample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public User createUser(User user) {
        User createdUser = userRepo.save(user);
        return createdUser;
    }
}
