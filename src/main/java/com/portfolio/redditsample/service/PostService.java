package com.portfolio.redditsample.service;

import com.portfolio.redditsample.model.Post;
import com.portfolio.redditsample.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPosts() {

        return postRepository.findAll();
    }

    public Post getPostById(Long id) {

        if(!postRepository.findById(id).isPresent()){
            return null;
        } else {
            return postRepository.findById(id).get();
        }
    }
}
