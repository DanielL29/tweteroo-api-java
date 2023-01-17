package com.tweteroo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.domain.User;
import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.repository.InMemoryUserRepo;

@RestController
@RequestMapping("/api/users/sign-up")
public class UserController {
    InMemoryUserRepo userRepo = new InMemoryUserRepo();

    @PostMapping
    public String signUp(@RequestBody UserDTO req) {
        this.userRepo.create(new User(req.username(), req.avatar()));

        return "OK";
    }
}
