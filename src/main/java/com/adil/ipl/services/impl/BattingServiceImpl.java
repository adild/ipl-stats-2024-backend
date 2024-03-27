package com.adil.ipl.services.impl;

import com.adil.ipl.entities.*;
import com.adil.ipl.repositories.BattingRepository;
import com.adil.ipl.services.BattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattingServiceImpl implements BattingService {

    BatsmanAgainstTeamInfo bati = new BatsmanAgainstTeamInfo();

    @Autowired
    private BattingRepository battingRepository;

    @Override
    public BatsmanAgainstTeamInfo getBatsmanAgainstTeam(String striker, String bowling_team) {
        int balls = 0 ;
        float totalRuns = 0;
        int totalWickets = 0;

        List<BattingAgainstTeamI> batsmanAgainstTeam = battingRepository.getBatsmanAgainstTeam(striker, bowling_team);

        for (BattingAgainstTeamI bat : batsmanAgainstTeam) {

            String ball = bat.getBall();
            balls += Integer.parseInt(ball);

            String runsOffBat = bat.getRunsOffBat();
            totalRuns += Float.parseFloat(runsOffBat);

            String wickets = bat.getWickets();
            totalWickets += Integer.parseInt(wickets);

        }

        float strikerRate = (totalRuns / balls) * 100;
        float average = (totalRuns / totalWickets);

        bati.setBattingAgainstTeamData(batsmanAgainstTeam);
        bati.setTotalRuns(totalRuns);
        bati.setStrikerRate(strikerRate);
        bati.setAverage(average);

        return bati;
    }

    @Override
    public List<BattingOnVenueI> getBatsmanAgainstVenue(String striker, String venue) {
        return battingRepository.getBatsmanAgainstVenue(striker, venue);
    }

    @Override
    public List<BattingAgainstBowlerI> getBatsmanAgainstBowler(String striker, String Bowler) {
        return battingRepository.getBatsmanAgainstBowler(striker, Bowler);
    }

    @Override
    public List<BattingLastScoresI> getBatsmanLastScores(String striker) {
        return battingRepository.getBatsmanLastScores(striker);
    }

    public List<BattingAgainstTeamI> getBatsmanInfoAgainstTeam(String striker, String bowling_team) {

        List<BattingAgainstTeamI> batsmanAgainstTeam = battingRepository.getBatsmanAgainstTeam(striker, bowling_team);

        return batsmanAgainstTeam;

    }

    /**
     * Calculate striker rate and average of a batsman
     * @param batsmanAgainstTeam
     * @return object containing striker rate and average

    private BatsmanInfoAgainstTeam CalculateStrikerRateAndAverage(List<BattingAgainstTeamI> batsmanAgainstTeam) {

    for (BattingAgainstTeamI bat : batsmanAgainstTeam) {

    String ball = bat.getBall();
    balls += Integer.parseInt(ball);

    String runsOffBat = bat.getRunsOffBat();
    totalRuns += Integer.parseInt(runsOffBat);

    String wickets = bat.getWickets();
    totalWickets += Integer.parseInt(wickets);

    }

    int strikerRate = (totalRuns / balls) * 100;
    int average = (totalRuns / totalWickets) * 100;
    biat.setStrikerRate(strikerRate);
    biat.setAverage(average);

    return biat;

    }
     */
}
