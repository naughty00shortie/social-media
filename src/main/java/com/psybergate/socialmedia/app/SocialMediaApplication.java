package com.psybergate.socialmedia.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.psybergate.socialmedia.domain"})
@EnableJpaRepositories(basePackages = {"com.psybergate.socialmedia.repository"})
@SpringBootApplication(scanBasePackages = {"com.psybergate.socialmedia"})
public class SocialMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApplication.class, args);
	}

}
