package com.tweteroo.api.tweets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.tweets.model.Tweet;

public interface H2TweetRepo extends JpaRepository<Tweet, Long> {
    
}
