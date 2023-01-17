package com.tweteroo.api.users.repository;

import java.util.ArrayList;
import java.util.List;

import com.tweteroo.api.users.domain.User;

public class InMemoryUserRepo {
    private List<User> users = new ArrayList<>();

    public void create(User user) {
        user.setId(this.users.size() + 1);

        this.users.add(user);
    }

    public List<User> list() {
        return this.users;
    }
}
