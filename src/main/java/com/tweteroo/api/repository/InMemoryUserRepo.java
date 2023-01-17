package com.tweteroo.api.repository;

import java.util.ArrayList;
import java.util.List;

import com.tweteroo.api.domain.User;

public class InMemoryUserRepo {
    private List<User> users = new ArrayList<>();

    public void create(User user) {
        this.users.add(user);
    }

    public List<User> list() {
        return this.users;
    }
}
