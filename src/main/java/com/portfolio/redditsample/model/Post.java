package com.portfolio.redditsample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    private int id;
    private String name;
    private User user;
    private SubReddit subReddit;
    private Comment comment;
}
