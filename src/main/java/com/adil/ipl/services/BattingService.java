package com.adil.ipl.services;

import com.adil.ipl.entities.*;

import java.util.List;

public interface BattingService {

    BatsmanAgainstTeamInfo getBatsmanAgainstTeam(String striker, String bowling_team);

    List<BattingOnVenueI> getBatsmanAgainstVenue(String striker, String venue);

    List<BattingAgainstBowlerI> getBatsmanAgainstBowler(String striker, String Bowler);

    List<BattingLastScoresI> getBatsmanLastScores(String striker);

//    BatsmanInfoAgainstTeam getBatsmanInfoAgainstTeam(String striker, String bowling_team);
}
