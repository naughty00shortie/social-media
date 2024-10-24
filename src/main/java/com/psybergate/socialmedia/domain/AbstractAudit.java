package com.psybergate.socialmedia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public class AbstractAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private LocalDate createdDate;

  @JsonIgnore
  private boolean deleted;
}
