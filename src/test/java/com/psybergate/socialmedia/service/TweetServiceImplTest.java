package com.psybergate.socialmedia.service;

import com.psybergate.socialmedia.domain.Tweet;
import com.psybergate.socialmedia.repository.TweetRepository;
import com.psybergate.socialmedia.service.impl.TweetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TweetServiceImplTest {

  @Mock
  private TweetRepository tweetRepository;

  @InjectMocks
  private TweetServiceImpl tweetService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testCreateTweet() {
    Tweet tweet = new Tweet();
    tweet.setMessage("yeet");
    when(tweetRepository.save(any(Tweet.class))).thenReturn(tweet);

    Tweet createdTweet = tweetService.createTweet(tweet);

    assertEquals("yeet", createdTweet.getMessage());
    verify(tweetRepository, times(1)).save(tweet);
  }

  @Test
  public void testDeleteTweet() {
    Long tweetId = 1L;
    doNothing().when(tweetRepository).deleteById(tweetId);

    tweetService.deleteTweet(tweetId);

    verify(tweetRepository, times(1)).deleteById(tweetId);
  }

  @Test
  public void testGetTweets() {
    Pageable pageable = PageRequest.of(0, 10);
    Page<Tweet> tweetPage = new PageImpl<>(Collections.singletonList(new Tweet()));
    when(tweetRepository.findAll(pageable)).thenReturn(tweetPage);

    Page<Tweet> result = tweetService.getTweets(pageable);

    assertEquals(1, result.getTotalElements());
    verify(tweetRepository, times(1)).findAll(pageable);
  }

  @Test
  public void testCreateMillionTweets() {
    for (int i = 0; i < 1_000_000; i++) {
      Tweet tweet = new Tweet();
      tweet.setMessage("Tweet number " + i);
      when(tweetRepository.save(any(Tweet.class))).thenReturn(tweet);
      tweetService.createTweet(tweet);
    }
    verify(tweetRepository, times(1_000_000)).save(any(Tweet.class));
  }
}