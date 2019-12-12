package com.portfolio.redditsample.model;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_subreddits",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subreddit_id"))
    private List<Subreddit> subReddits;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
