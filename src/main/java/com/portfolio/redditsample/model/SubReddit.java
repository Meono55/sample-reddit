package com.portfolio.redditsample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubReddit {
    private int id;
    private String name;
    private User user;
    private Post post;
}
