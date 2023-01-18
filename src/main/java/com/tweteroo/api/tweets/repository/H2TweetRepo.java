package com.tweteroo.api.tweets.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.tweets.model.Tweet;

public interface H2TweetRepo extends JpaRepository<Tweet, Long> {
    List<Tweet> findAllByOrderByIdDesc();
    Page<Tweet> findAllByOrderByIdDesc(Pageable pageable);
    List<Tweet> findAllByUsernameOrderByIdDesc(String username);
}
