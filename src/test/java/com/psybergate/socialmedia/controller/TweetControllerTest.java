//package com.psybergate.socialmedia.controller;
//
//import com.psybergate.socialmedia.domain.Tweet;
//import com.psybergate.socialmedia.service.TweetService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Collections;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(TweetController.class)
//@ContextConfiguration(classes = {TweetController.class})
//class TweetControllerBulkTest {
//
//  @Autowired
//  private MockMvc mockMvc;
//
//  @MockBean
//  private TweetService tweetService;
//
//  @BeforeEach
//  public void setUp() {
//    MockitoAnnotations.openMocks(this);
//  }
//
//  @Test
//  public void Testbulkcreatetweets() throws Exception {
//    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//
//    for (int i = 0; i < 1000000; i++) {
//      int finalI = i;
//      executorService.submit(() -> {
//        try {
//          Tweet tweet = new Tweet();
//          tweet.setMessage("Test tweet " + finalI);
//          when(tweetService.createTweet(any(Tweet.class))).thenReturn(tweet);
//
//          mockMvc.perform(post("/tweets")
//                          .contentType("application/json")
//                          .content("{\"message\": \"Test tweet " + finalI + "\"}"))
//                  .andExpect(status().isOk());
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      });
//    }
//
//    executorService.shutdown();
//    executorService.awaitTermination(1, TimeUnit.HOURS);
//  }
//
//  @Test
//  public void TestHunderedThousandcreatetweets() throws Exception {
//    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//
//    for (int i = 0; i < 100_000; i++) {
//      int finalI = i;
//      executorService.submit(() -> {
//        try {
//          Tweet tweet = new Tweet();
//          tweet.setMessage("Test tweet " + finalI);
//          when(tweetService.createTweet(any(Tweet.class))).thenReturn(tweet);
//
//          mockMvc.perform(post("/tweets")
//                          .contentType("application/json")
//                          .content("{\"message\": \"Test tweet " + finalI + "\"}"))
//                  .andExpect(status().isOk());
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      });
//    }
//
//    executorService.shutdown();
//    executorService.awaitTermination(1, TimeUnit.HOURS);
//  }
//
//  @Test
//  public void testBulkReadTweets() throws Exception {
//    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//
//    for (int i = 0; i < 1000000; i++) {
//      int finalI = i;
//      executorService.submit(() -> {
//        try {
//          Tweet tweet = new Tweet();
//          tweet.setMessage("Test tweet " + finalI);
//          Pageable pageable = PageRequest.of(0, 1);
//          Page<Tweet> tweetPage = new PageImpl<>(Collections.singletonList(tweet));
//          when(tweetService.getTweets(pageable)).thenReturn(tweetPage);
//
//          mockMvc.perform(get("/tweets")
//                          .param("page", "0")
//                          .param("size", "1"))
//                  .andExpect(status().isOk())
//                  .andExpect(jsonPath("$.content[0].message").value("Test tweet " + finalI));
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      });
//    }
//
//    executorService.shutdown();
//    executorService.awaitTermination(1, TimeUnit.HOURS);
//  }
//
//  @Test
//  public void testBulkUpdateTweets() throws Exception {
//    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//
//    for (int i = 0; i < 1000000; i++) {
//      int finalI = i;
//      executorService.submit(() -> {
//        try {
//          Tweet tweet = new Tweet();
//          tweet.setMessage("Updated tweet " + finalI);
//          when(tweetService.createTweet(any(Tweet.class))).thenReturn(tweet);
//
//          mockMvc.perform(put("/tweets/" + finalI)
//                          .contentType("application/json")
//                          .content("{\"message\": \"Updated tweet " + finalI + "\"}"))
//                  .andExpect(status().isOk());
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      });
//    }
//
//    executorService.shutdown();
//    executorService.awaitTermination(1, TimeUnit.HOURS);
//  }
//
//  @Test
//  public void testBulkDeleteTweets() throws Exception {
//    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//
//    for (int i = 0; i < 1000000; i++) {
//      int finalI = i;
//      executorService.submit(() -> {
//        try {
//          doNothing().when(tweetService).deleteTweet(String.valueOf(finalI));
//
//          mockMvc.perform(delete("/tweets/" + finalI))
//                  .andExpect(status().isOk());
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      });
//    }
//
//    executorService.shutdown();
//    executorService.awaitTermination(1, TimeUnit.HOURS);
//  }
//}