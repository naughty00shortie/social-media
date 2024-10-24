package com.psybergate.socialmedia.repository;

import com.psybergate.socialmedia.domain.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
  Tweet findByMessage(String message);

  Page<Tweet> findAll(Pageable pageable);
}