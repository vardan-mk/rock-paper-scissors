package com.nobel.rock_paper_scissors.repository;

import com.nobel.rock_paper_scissors.entity.ScoreEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {
  Optional<ScoreEntity> findByEmail(String email);
}