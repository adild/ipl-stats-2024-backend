package com.adil.ipl.controllers;

import com.adil.ipl.entities.BowlerAgainstAllTeamI;
import com.adil.ipl.entities.BowlingAgainstBatsmanI;
import com.adil.ipl.entities.BowlingAgainstTeamI;
import com.adil.ipl.entities.BowlingOnVenueI;
import com.adil.ipl.services.BowlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bowling")
public class BowlingController {

    @Autowired
    private BowlingService bowlingService;

    @GetMapping("/againstTeam/{bowler}/{battingTeam}")
    public ResponseEntity<List<BowlingAgainstTeamI>> getBowlingAgainstTeam(@PathVariable String bowler, @PathVariable String battingTeam) {

        List<BowlingAgainstTeamI> bowlingAgainstTeam = bowlingService.getBowlingAgainstTeam(bowler, battingTeam);

        return ResponseEntity.ok(bowlingAgainstTeam);

    }

    @GetMapping("/onVenue/{bowler}/{venue}")
    public ResponseEntity<List<BowlingOnVenueI>> getBowlingOnVenue(@PathVariable String bowler, @PathVariable String venue) {

        List<BowlingOnVenueI> bowlingOnVenue = bowlingService.getBowlingOnVenue(bowler, venue);

        return ResponseEntity.ok(bowlingOnVenue);

    }

    @GetMapping("/againstBatsman/{bowler}/{striker}")
    public ResponseEntity<List<BowlingAgainstBatsmanI>> getBowlingAgainstBatsman(@PathVariable String bowler, @PathVariable String striker) {

        List<BowlingAgainstBatsmanI> bowlingAgainstBatmsman = bowlingService.getBowlingAgainstBatmsman(bowler, striker);

        return ResponseEntity.ok(bowlingAgainstBatmsman);
    }

    @GetMapping("/againstAllTeams/{bowler}")
    public ResponseEntity<List<BowlerAgainstAllTeamI>> getBowlingAgainstAllTeams(@PathVariable String bowler) {

        List<BowlerAgainstAllTeamI> bowlingAgainstAllTeams = bowlingService.getBowlingAgainstAllTeam(bowler);

        return ResponseEntity.ok(bowlingAgainstAllTeams);
    }
}
