package com.psybergate.socialmedia.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableCassandraRepositories(basePackages = {"com.psybergate.socialmedia.repository"})
@SpringBootApplication(scanBasePackages = {"com.psybergate.socialmedia"})
@EntityScan("com.psybergate.socialmedia")
@EnableAsync
public class SocialMediaApplication {

  public static void main(String[] args) {
    SpringApplication.run(SocialMediaApplication.class, args);
  }

}
