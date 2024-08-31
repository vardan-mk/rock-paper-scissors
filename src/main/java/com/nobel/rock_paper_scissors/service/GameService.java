package com.nobel.rock_paper_scissors.service;

import com.nobel.rock_paper_scissors.dto.PlayRequest;
import com.nobel.rock_paper_scissors.dto.PlayResponse;
import com.nobel.rock_paper_scissors.dto.StatisticsResponse;

public interface GameService {
  PlayResponse play(String email, PlayRequest request);

  StatisticsResponse getStatistics(String email);
}