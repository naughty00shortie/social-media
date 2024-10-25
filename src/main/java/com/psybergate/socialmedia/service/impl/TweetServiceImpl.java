package com.psybergate.socialmedia.service.impl;

import com.psybergate.socialmedia.domain.Tweet;
import com.psybergate.socialmedia.repository.TweetRepository;
import com.psybergate.socialmedia.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class TweetServiceImpl implements TweetService {

  private final TweetRepository tweetRepository;

  @Autowired
  public TweetServiceImpl(TweetRepository tweetRepository) {
    this.tweetRepository = tweetRepository;
  }

  @Override
  public Tweet createTweet(Tweet tweet) {
    return tweetRepository.save(tweet);
  }

  @Override
  public Tweet updateTweet(Tweet tweet) {
    return tweetRepository.save(tweet);
  }

  @Override
  public void deleteTweet(UUID tweetId) {
    tweetRepository.deleteById(tweetId);
  }

  @Override
  public Page<Tweet> getTweets(Pageable pageable) {
    return (Page<Tweet>) tweetRepository.findAll(pageable);
  }

  @Async
  @Override
  public CompletableFuture<Tweet> createTweetAsync(Tweet tweet) {
    return CompletableFuture.completedFuture(tweetRepository.save(tweet));
  }

}