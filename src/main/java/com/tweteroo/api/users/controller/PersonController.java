package com.tweteroo.api.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.users.dto.PersonDTO;
import com.tweteroo.api.users.model.Person;
import com.tweteroo.api.users.repository.H2PersonRepo;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class PersonController {

    @Autowired
    private H2PersonRepo repo;
    
    @PostMapping("/sign-up")
    public String signUp(@RequestBody PersonDTO req) {
        repo.save(new Person(req));

        return "OK";
    }
}
