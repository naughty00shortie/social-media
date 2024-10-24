package com.psybergate.socialmedia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(indexes = @Index(name = "index_user_id", columnList = "user_id"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tweet extends AbstractAudit {

  String message;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  User user;
}