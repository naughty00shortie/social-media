package com.psybergate.socialmedia.service;

import com.psybergate.socialmedia.domain.User;

public interface UserService {

  User createUser(User user);

  void deleteUser(Long userId);
}