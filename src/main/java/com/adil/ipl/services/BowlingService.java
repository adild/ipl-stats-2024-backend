package com.adil.ipl.services;

import com.adil.ipl.entities.BowlerAgainstAllTeamI;
import com.adil.ipl.entities.BowlingAgainstBatsmanI;
import com.adil.ipl.entities.BowlingAgainstTeamI;
import com.adil.ipl.entities.BowlingOnVenueI;

import java.util.List;

public interface BowlingService {

    public List<BowlingAgainstTeamI> getBowlingAgainstTeam(String bowler, String battingTeam);

    public List<BowlingOnVenueI> getBowlingOnVenue(String bowler, String venue);

    List<BowlingAgainstBatsmanI> getBowlingAgainstBatmsman(String bowler, String striker);

    List<BowlerAgainstAllTeamI> getBowlingAgainstAllTeam(String bowler);

}