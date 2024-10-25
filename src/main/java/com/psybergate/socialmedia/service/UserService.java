package com.psybergate.socialmedia.service;

import com.psybergate.socialmedia.domain.User;

import java.util.UUID;

public interface UserService {

  User createUser(User user);

  User updateUser(User user);

  void deleteUser(UUID userId);
}