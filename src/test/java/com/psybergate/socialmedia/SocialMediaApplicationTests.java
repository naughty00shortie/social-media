package com.psybergate.socialmedia;

import com.psybergate.socialmedia.app.SocialMediaApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SocialMediaApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
class SocialMediaApplicationTests {

}
