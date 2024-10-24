package com.psybergate.socialmedia.controller;

import com.psybergate.socialmedia.domain.Tweet;
import com.psybergate.socialmedia.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class TweetController {

  private final TweetService tweetService;

  @Autowired
  public TweetController(TweetService tweetService) {
    this.tweetService = tweetService;
  }

  @GetMapping("/tweets")
  public Page<Tweet> getTweets(@RequestParam int page, @RequestParam int size) {
    Pageable pageable = PageRequest.of(page, size);
    return tweetService.getTweets(pageable);
  }

  @PostMapping("/tweets")
  public Tweet createTweet(@RequestBody Tweet tweet) {
    return tweetService.createTweet(tweet);
  }
}