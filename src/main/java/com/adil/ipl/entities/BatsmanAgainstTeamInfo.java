package com.adil.ipl.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BatsmanAgainstTeamInfo {

    private float strikerRate;
    private float average;
    private float totalRuns;

    List<BattingAgainstTeamI> battingAgainstTeamData;

}