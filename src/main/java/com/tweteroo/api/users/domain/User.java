package com.tweteroo.api.users.domain;

public class User {
    int id;
    String username;
    String avatar;

    public User() {}

    public User(String username, String avatar) {
        this.username = username;
        this.avatar = avatar;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getAvatar() {
        return this.avatar;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
