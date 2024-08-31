package com.nobel.rock_paper_scissors.service;

import com.nobel.rock_paper_scissors.dto.PlayRequest;
import com.nobel.rock_paper_scissors.dto.PlayResponse;
import com.nobel.rock_paper_scissors.dto.StatisticsResponse;
import com.nobel.rock_paper_scissors.entity.ScoreEntity;
import com.nobel.rock_paper_scissors.enumaration.Choice;
import com.nobel.rock_paper_scissors.enumaration.Status;
import com.nobel.rock_paper_scissors.exception.UserNotFoundException;
import com.nobel.rock_paper_scissors.repository.ScoreRepository;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

  private final ScoreRepository repository;
  private final Random random = new Random();

  @Override
  public PlayResponse play(final String email, final PlayRequest request) {

    final Choice serverChoice = generateRandomChoice();
    final Choice userChoice = Choice.getChoiceByName(request.choice());
    final int compareResult = Choice.compareChoice(serverChoice, userChoice);
    Status status = Status.checkPlayStatus(compareResult);

    final ScoreEntity score = repository.findByEmail(email).orElse(new ScoreEntity(email));

    switch (status) {
      case WIN -> score.setWin(score.getWin() + 1);
      case LOSE -> score.setLose(score.getLose() + 1);
      default -> score.setDraw(score.getDraw() + 1);
    }

    repository.save(score);

    log.info("Status of game was: {} for user: {}", status, email);

    return new PlayResponse(status);
  }

  @Override
  public StatisticsResponse getStatistics(final String email) {
    final ScoreEntity score = repository.findByEmail(email).orElseThrow(UserNotFoundException::new);

    log.info("Retrieving statistics for user: {}", email);

    return new StatisticsResponse(score.getEmail(), score.getWin(), score.getLose(), score.getDraw());
  }

  private Choice generateRandomChoice() {

    int randomNumber = random.nextInt(3) + 1; // next int work in range [0..2] so +1 to get [1..3]

    return Choice.getChoiceById(randomNumber);
  }
}