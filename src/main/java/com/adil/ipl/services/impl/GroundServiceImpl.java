package com.adil.ipl.services.impl;

import com.adil.ipl.entities.GroundInfoI;
import com.adil.ipl.helper.MatchSummary;
import com.adil.ipl.repositories.GroundRepository;
import com.adil.ipl.services.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroundServiceImpl implements GroundService {

    @Autowired
    private GroundRepository groundRepository;

    @Autowired
    private MatchSummary matchSummary;

    public int i = 0;

    @Override
    public List<GroundInfoI> getGroundInfo(String venue) {
        List<GroundInfoI> groundInfo = groundRepository.getGroundInfo(venue);
        for (GroundInfoI g : groundInfo){

            System.out.println("g.getMatchId() : "+g.getMatchId());
            System.out.println("g.getInnings: "+g.getInnings());
            System.out.println("g.getVenue(): "+g.getVenue());
            System.out.println("g.getBattingTeam: "+g.getBattingTeam());
            System.out.println("g.getBowlingTeam(): "+g.getBowlingTeam());
            System.out.println("g.getRunsOffBat() " +g.getRunsOffBat());

        }


        while(i < groundInfo.size() - 1) {

            GroundInfoI team1 = groundInfo.get(i);
            GroundInfoI team2 = groundInfo.get(i + 1);

            matchSummary.scoreBoard(team1, team2);

            i=i+2;

        }

        return groundRepository.getGroundInfo(venue);
    }
}
