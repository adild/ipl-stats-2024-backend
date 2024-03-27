package com.adil.ipl.services.impl;

import com.adil.ipl.entities.BowlingTeamI;
import com.adil.ipl.entities.LoadFields;
import com.adil.ipl.entities.StrikerLoadI;
import com.adil.ipl.entities.VenueLoadI;
import com.adil.ipl.repositories.LoadRepository;
import com.adil.ipl.services.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    private LoadRepository loadRepository;

    @Override
    public LoadFields getLoadFields() {
        LoadFields loadFields = new LoadFields();
        loadFields.setStrikers(loadRepository.getLoadStrikers());
        loadFields.setBowlers(loadRepository.getLoadBowlers());
        loadFields.setTeams(loadRepository.getLoadTeams());
        loadFields.setVenues(loadRepository.getLoadVenues());

        Set<BowlingTeamI> loadTeams = loadRepository.getLoadTeams();
        for (BowlingTeamI t : loadTeams) {
            System.out.println("Team in service: "+t.getBowlingTeam());
        }

        return loadFields;
    }
}