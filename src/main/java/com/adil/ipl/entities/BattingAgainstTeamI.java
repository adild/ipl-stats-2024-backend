package com.adil.ipl.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"striker", "battingTeam", "bowlingTeam", "ball", "runsOffBat", "venue", "season", "startDate"})
public interface BattingAgainstTeamI {

    String getStriker();
    String getBattingTeam();
    String getBowlingTeam();
    String getRunsOffBat();
    String getBall();
    String getSeason();
    String getVenue();
    String getStartDate();
    String getWickets();
}