package com.adil.ipl.services.impl;

import com.adil.ipl.entities.BowlerAgainstAllTeamI;
import com.adil.ipl.entities.BowlingAgainstBatsmanI;
import com.adil.ipl.entities.BowlingAgainstTeamI;
import com.adil.ipl.entities.BowlingOnVenueI;
import com.adil.ipl.repositories.BowlingRepository;
import com.adil.ipl.services.BowlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BowlingServiceImpl implements BowlingService {

    @Autowired
    private BowlingRepository bowlingRepository;

    @Override
    public List<BowlingAgainstTeamI> getBowlingAgainstTeam(String bowler, String battingTeam) {
        return bowlingRepository.getBowlingAgainstTeam(bowler, battingTeam);
    }

    @Override
    public List<BowlingOnVenueI> getBowlingOnVenue(String bowler, String venue) {
        return bowlingRepository.getBowlingOnVenue(bowler, venue);
    }

    @Override
    public List<BowlingAgainstBatsmanI> getBowlingAgainstBatmsman(String bowler, String striker) {
        return bowlingRepository.getBowlerAgainstBatman(bowler, striker);
    }

    @Override
    public List<BowlerAgainstAllTeamI> getBowlingAgainstAllTeam(String bowler) {
        return bowlingRepository.getBowlerAgainstAllTeams(bowler);
    }
}

