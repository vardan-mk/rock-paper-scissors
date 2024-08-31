package com.nobel.rock_paper_scissors.enumaration;

import com.nobel.rock_paper_scissors.exception.InvalidChoiceValueException;
import java.util.Arrays;
import lombok.Getter;

@Getter
public enum Choice {

  ROCK(1),
  PAPER(2),
  SCISSORS(3);

  private final int id;

  Choice(final int id) {
    this.id = id;
  }

  public static Choice getChoiceById(final int id) {
    return Arrays.stream(Choice.values())
        .filter(choice -> choice.getId() == id)
        .findFirst()
        .orElseThrow(InvalidChoiceValueException::new);
  }

  public static Choice getChoiceByName(final String name) {
    return Arrays.stream(Choice.values())
        .filter(choice -> choice.name().equals(name))
        .findFirst()
        .orElseThrow(InvalidChoiceValueException::new);
  }

  public static int compareChoice(final Choice serverChoice, final Choice userChoice) {
    int result = 0;

    if (serverChoice.equals(userChoice)) return result;

    switch (serverChoice) {
      case ROCK -> result = userChoice.equals(SCISSORS) ? -1 : 1;
      case PAPER -> result = userChoice.equals(SCISSORS) ? 1 : -1;
      default -> result = userChoice.equals(ROCK) ? 1 : -1;
      }

      return result;
  }
}