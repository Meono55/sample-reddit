package com.portfolio.redditsample.controller;

import com.portfolio.redditsample.model.Subreddit;
import com.portfolio.redditsample.service.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subreddit")
public class SubredditController {

    @Autowired
    SubredditService subredditService;

    @PostMapping(value = "/create-reddit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subreddit> createSubreddit(@RequestBody Subreddit subreddit){
        return new ResponseEntity<>(subredditService.createSubreddit(subreddit), HttpStatus.OK);
    }

    @GetMapping(value = "/get-reddits", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Subreddit>> getAllSubs(){
        return new ResponseEntity<>(subredditService.getAllSubs(), HttpStatus.OK);
    }

    @GetMapping(value = "/get-sub/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subreddit> getSubById(@PathVariable("id") Long subId){
        return new ResponseEntity<>(subredditService.getSubById(subId), HttpStatus.OK);
    }
}
