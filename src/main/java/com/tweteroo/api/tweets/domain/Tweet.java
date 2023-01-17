package com.tweteroo.api.tweets.domain;

public class Tweet {
    int id;
    String username;
    String tweet;

    public Tweet() {}

    public Tweet(String username, String tweet) {
        this.username = username;
        this.tweet = tweet;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getTweet() {
        return this.tweet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
