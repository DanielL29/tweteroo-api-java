package com.tweteroo.api.domain;

public class User {
    String username;
    String avatar;

    public User() {}

    public User(String username, String avatar) {
        this.username = username;
        this.avatar = avatar;
    }

    public String getUsername() {
        return this.username;
    }

    public String getAvatar() {
        return this.avatar;
    } 

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
