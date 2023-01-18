package com.tweteroo.api.tweets.model;

import com.tweteroo.api.tweets.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {

    public Tweet(TweetDTO tweet) {
        this.username = tweet.username();
        this.avatar = tweet.avatar();
        this.text = tweet.text();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String username;

    @Column(nullable = false)
    private String avatar;

    @Column(length = 1000, nullable = false)
    private String text;
}
