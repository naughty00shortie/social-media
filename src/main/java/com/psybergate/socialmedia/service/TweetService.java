package com.psybergate.socialmedia.service;

import com.psybergate.socialmedia.domain.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface TweetService {

  Tweet createTweet(Tweet tweet);

  Tweet updateTweet(Tweet tweet);

  void deleteTweet(UUID tweetId);

  Page<Tweet> getTweets(Pageable pageable);

  CompletableFuture<Tweet> createTweetAsync(Tweet tweet);
}