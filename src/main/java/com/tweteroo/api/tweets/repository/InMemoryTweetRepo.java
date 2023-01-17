package com.tweteroo.api.tweets.repository;

import java.util.ArrayList;
import java.util.List;

import com.tweteroo.api.tweets.domain.Tweet;

public class InMemoryTweetRepo {
    private List<Tweet> tweets = new ArrayList<>();

    public void create(Tweet tweet) {
        tweet.setId(this.tweets.size() + 1);

        this.tweets.add(tweet);
    }

    public List<Tweet> list() {
        return this.tweets;
    }
}
