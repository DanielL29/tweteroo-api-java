package com.tweteroo.api.tweets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.tweets.model.Tweet;
import com.tweteroo.api.tweets.repository.H2TweetRepo;
import com.tweteroo.api.tweets.dto.TweetDTO;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private H2TweetRepo repo;

    @GetMapping
    public List<Tweet> listTweets() {
        PageRequest pageRequest = PageRequest.of(0, 5, Direction.DESC, "id");
        Page<Tweet> tweetsPage = repo.findAll(pageRequest); 

        return tweetsPage.getContent();   
    }

    @PostMapping
    public String createTweet(@RequestBody TweetDTO req, @RequestHeader(value="User") String username) {
        Tweet tweet = new Tweet(req);
        tweet.setUsername(username);

        repo.save(tweet);

        return "OK";
    }
}
