package com.psybergate.socialmedia.service.impl;

import com.psybergate.socialmedia.domain.User;
import com.psybergate.socialmedia.repository.UserRepository;
import com.psybergate.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public void deleteUser(Long userId) {
    userRepository.deleteById(userId);
  }
}