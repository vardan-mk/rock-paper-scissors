package com.nobel.rock_paper_scissors.enumaration;

public enum Status {
  WIN, LOSE, DRAW;

  public static Status checkPlayStatus(int i) {
    return i < 0 ? LOSE : i > 0 ? WIN : DRAW;
  }
}