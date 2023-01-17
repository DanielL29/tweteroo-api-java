package com.tweteroo.api.users.useCases.signUp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tweteroo.api.users.domain.User;
import com.tweteroo.api.users.repository.InMemoryUserRepo;
import com.tweteroo.api.users.useCases.signUp.dto.SignUpDTO;

@RestController
@RequestMapping("/api/auth/sign-up")
public class SignUpController {
    InMemoryUserRepo userRepo = new InMemoryUserRepo();

    @PostMapping
    public String signUp(@RequestBody SignUpDTO req) {
        this.userRepo.create(new User(req.username(), req.avatar()));

        return "OK";
    }
}
