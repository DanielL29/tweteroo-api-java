package com.tweteroo.api.tweets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.tweteroo.api.tweets.model.Tweet;
import com.tweteroo.api.tweets.repository.H2TweetRepo;
import com.tweteroo.api.users.model.Person;
import com.tweteroo.api.users.repository.H2PersonRepo;
import com.tweteroo.api.tweets.dto.TweetDTO;

@RestController
@CrossOrigin
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private H2TweetRepo tweetRepo;

    @Autowired
    private H2PersonRepo personRepo;

    @GetMapping
    public List<Tweet> listTweets(@RequestParam(required = false) String page) {
        int pageStart;

        if (page == null) {
            return tweetRepo.findAll(); 
        }

        pageStart = Integer.parseInt(page); 

        return tweetRepo.findAllByOrderByIdDesc(PageRequest.of(pageStart, 5)).getContent();  
    }

    @GetMapping("/{username}")
    public List<Tweet> listTweetsByUsername(@PathVariable(required = false, name = "username") String username) {
        return tweetRepo.findAllByUsernameOrderByIdDesc(username);  
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) 
    public String createTweet(@RequestBody TweetDTO req, @RequestHeader(value="User") String username) {
        Tweet tweet = new Tweet(req);
        Person person = personRepo.findByUsername(username);

        tweet.setUsername(username);
        tweet.setAvatar(person.getAvatar());

        tweetRepo.save(tweet);

        return "OK";
    }
}
