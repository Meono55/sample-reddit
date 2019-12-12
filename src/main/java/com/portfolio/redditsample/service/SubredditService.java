package com.portfolio.redditsample.service;

import com.portfolio.redditsample.model.Subreddit;
import com.portfolio.redditsample.repository.SubredditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubredditService {

    @Autowired
    SubredditRepository subredditRepository;

    public Subreddit createSubreddit(Subreddit subreddit){
        return subredditRepository.save(subreddit);
    }

    public List<Subreddit> getAllSubs() {
        return subredditRepository.findAll();
    }

    public Subreddit getSubById(Long subId) {
        if(!subredditRepository.findById(subId).isPresent()){
            return null;
        }
        else {
            return subredditRepository.findById(subId).get();
        }

    }
}
