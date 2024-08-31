package com.nobel.rock_paper_scissors.dto;

public record StatisticsResponse(String email, int win, int lose, int draw) {}