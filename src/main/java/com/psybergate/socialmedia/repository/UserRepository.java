package com.psybergate.socialmedia.repository;

import com.psybergate.socialmedia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findByName(String name);

  List<User> findByEmail(String email);

  List<User> findByDeleted(boolean deleted);
}