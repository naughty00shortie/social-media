//package com.psybergate.socialmedia.service;
//
//import com.psybergate.socialmedia.domain.User;
//import com.psybergate.socialmedia.repository.UserRepository;
//import com.psybergate.socialmedia.service.impl.UserServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class UserServiceImplTest {
//
//  @Mock
//  private UserRepository userRepository;
//
//  @InjectMocks
//  private UserServiceImpl userService;
//
//  @BeforeEach
//  public void setUp() {
//    MockitoAnnotations.openMocks(this);
//  }
//
//  @Test
//  public void testCreateUser() {
//    User user = new User();
//    user.setName("John Doe");
//    when(userRepository.save(any(User.class))).thenReturn(user);
//
//    User createdUser = userService.createUser(user);
//
//    assertEquals("John Doe", createdUser.getName());
//    verify(userRepository, times(1)).save(user);
//  }
//
//  @Test
//  public void testDeleteUser() {
//    Long userId = 1L;
//    doNothing().when(userRepository).deleteById(String.valueOf(userId));
//
//    userService.deleteUser(String.valueOf(userId));
//
//    verify(userRepository, times(1)).deleteById(String.valueOf(userId));
//  }
//}