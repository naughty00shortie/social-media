package com.psybergate.socialmedia.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractAudit {

  String name;

  String email;

  String password;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  List<Tweet> tweets;
}