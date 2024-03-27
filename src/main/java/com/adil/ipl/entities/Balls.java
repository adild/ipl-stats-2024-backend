package com.adil.ipl.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Balls {

    @Id
    private int id;

    private String match_id;
    private String season;
    private String start_date;
    private String venue;
    private String innings;
    private String ball;
    private String battingTeam;
    private String bowlingTeam;
    private String striker;
    private String non_striker;
    private String bowler;
    private String runsOffBat;
    private String extras;
    private String wides;
    private String noballs;
    private String byes;
    private String legbyes;
    private String penalty;
    private String wicket_type;
    private String player_dismissed;
    private String other_wicket_type;
    private String other_player_dismissed;

    @Transient
    private int strike_rate;

}