package com.psybergate.socialmedia.repository;

import com.psybergate.socialmedia.domain.Tweet;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface TweetRepository extends CassandraRepository<Tweet, UUID> {
  Tweet findByMessage(String message);
}