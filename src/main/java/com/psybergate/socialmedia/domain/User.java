package com.psybergate.socialmedia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {

  @PrimaryKey
  @CassandraType(type = CassandraType.Name.UUID)
  private UUID id = UUID.randomUUID();

  private String name;

  private String email;

  @JsonIgnore
  private boolean deleted;

  private LocalDateTime createdDate = LocalDateTime.now();

  @JsonIgnore
  @CreatedBy
  private String createdBy;

  @LastModifiedDate
  private LocalDateTime lastModifiedDate;
}