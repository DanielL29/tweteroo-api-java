package com.tweteroo.api.tweets.useCases.createTweet.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.tweets.domain.Tweet;
import com.tweteroo.api.tweets.repository.InMemoryTweetRepo;
import com.tweteroo.api.tweets.useCases.createTweet.dto.CreateTweetDTO;

@RestController
@RequestMapping("/api/tweets")
public class CreateTweetController {
    InMemoryTweetRepo tweetRepo = new InMemoryTweetRepo();

    @PostMapping
    public String createTweet(@RequestBody CreateTweetDTO req, @RequestHeader(value="User") String usernameHeader) {
        String username = usernameHeader;

        this.tweetRepo.create(new Tweet(username, req.tweet()));

        return "OK";
    }
}
