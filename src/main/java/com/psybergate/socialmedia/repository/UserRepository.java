package com.psybergate.socialmedia.repository;

import com.psybergate.socialmedia.domain.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CassandraRepository<User, UUID> {

  List<User> findByName(String name);

  List<User> findByEmail(String email);

  List<User> findByDeleted(boolean deleted);
}