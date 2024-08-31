package com.nobel.rock_paper_scissors.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_scores")
public class ScoreEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_email", nullable = false, unique = true)
  private String email;

  @Column(name = "win_count", nullable = false)
  private int win;
  @Column(name = "lose_count", nullable = false)
  private int lose;
  @Column(name = "draw_count", nullable = false)
  private int draw;

  public ScoreEntity(final String email) {
    this.email = email;
  }
}