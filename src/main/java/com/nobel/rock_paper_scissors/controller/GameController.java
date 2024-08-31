package com.nobel.rock_paper_scissors.controller;

import com.nobel.rock_paper_scissors.dto.PlayRequest;
import com.nobel.rock_paper_scissors.dto.PlayResponse;
import com.nobel.rock_paper_scissors.dto.StatisticsResponse;
import com.nobel.rock_paper_scissors.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/game")
public class GameController {

  private final GameService gameService;

  @PostMapping("/play")
  public ResponseEntity<PlayResponse> play(
      @RequestBody final PlayRequest playRequest,
      @RequestHeader("x-email") final String email) {
    return ResponseEntity.ok(gameService.play(email, playRequest));
  }

  @GetMapping("/statistics")
  public ResponseEntity<StatisticsResponse> getStatistics(@RequestHeader("x-email") final String email) {
    return ResponseEntity.ok(gameService.getStatistics(email));
  }
}