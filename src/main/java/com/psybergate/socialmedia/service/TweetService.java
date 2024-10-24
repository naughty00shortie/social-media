package com.psybergate.socialmedia.service;

import com.psybergate.socialmedia.domain.Tweet;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.concurrent.CompletableFuture;

public interface TweetService {
  Tweet createTweet(Tweet tweet);
  void deleteTweet(Long tweetId);

  Page<Tweet> getTweets(org.springframework.data.domain.Pageable pageable);

  CompletableFuture<Tweet> createTweetAsync(Tweet tweet);
  Page<Tweet> getTweets(Pageable pageable);
}