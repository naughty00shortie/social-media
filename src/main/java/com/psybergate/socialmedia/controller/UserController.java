package com.psybergate.socialmedia.controller;

import com.psybergate.socialmedia.domain.User;
import com.psybergate.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @DeleteMapping("/{userId}")
  public void deleteUser(@PathVariable Long userId) {
    userService.deleteUser(userId);
  }
}