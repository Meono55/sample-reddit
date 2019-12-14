package com.portfolio.redditsample.service;

import com.portfolio.redditsample.model.Subreddit;
import com.portfolio.redditsample.model.User;
import com.portfolio.redditsample.repository.SubredditRepository;
import com.portfolio.redditsample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    SubredditRepository subredditRepository;

    public User createUser(User user) {
        User createdUser = userRepo.save(user);
        return createdUser;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {

        return userRepo.findById(id).get();
    }

    public User joinSubreddit(Long userId, Long subId) {

        if(!subredditRepository.findById(subId).isPresent() && !userRepo.findById(userId).isPresent()){
            return null;
        }

        Subreddit currentSub = subredditRepository.findById(subId).get();
        User currentUser = userRepo.findById(userId).get();

        boolean add = currentUser.getSubReddits().add(currentSub);

        return userRepo.save(currentUser);
    }
}
