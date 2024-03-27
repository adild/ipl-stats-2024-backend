package com.adil.ipl.controllers;

import com.adil.ipl.entities.*;
import com.adil.ipl.services.BattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/batting")
public class BattingController {

    @Autowired
    private BattingService battingService;

    @GetMapping("/againstTeam/{striker}/{bowling_team}")
    public ResponseEntity<BatsmanAgainstTeamInfo> getBatsmanAgainstTeam(@PathVariable String striker, @PathVariable String bowling_team) {

        BatsmanAgainstTeamInfo batsmanAgainstTeam = battingService.getBatsmanAgainstTeam(striker, bowling_team);

//        Collections.sort();
        return ResponseEntity.ok(batsmanAgainstTeam);
    }

    @GetMapping("/againstVenue/{striker}/{venue}")
    public ResponseEntity<List<BattingOnVenueI>> getBatsmanAgainstVenue(@PathVariable String striker, @PathVariable String venue) {

        List<BattingOnVenueI> batsmanAgainstVenue = battingService.getBatsmanAgainstVenue(striker, venue);

        return ResponseEntity.ok(batsmanAgainstVenue);

    }

    @GetMapping("/againstBowler/{striker}/{bowler}")
    public ResponseEntity<List<BattingAgainstBowlerI>> getBatsmanAgainstBowler(@PathVariable String
                                                                                       striker, @PathVariable String bowler) {

        List<BattingAgainstBowlerI> batsmanAgainstBowler = battingService.getBatsmanAgainstBowler(striker, bowler);

        return ResponseEntity.ok(batsmanAgainstBowler);
    }

    @GetMapping("/againstAll/{striker}")
    public ResponseEntity<List<BattingLastScoresI>> getBatsmanAgainstAll(@PathVariable String
                                                                                 striker) {

        List<BattingLastScoresI> batsmanAgainstAll = battingService.getBatsmanLastScores(striker);

        return ResponseEntity.ok(batsmanAgainstAll);
    }

}
