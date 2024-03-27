package com.adil.ipl.controllers;

import com.adil.ipl.entities.BowlingTeamI;
import com.adil.ipl.entities.LoadFields;
import com.adil.ipl.entities.StrikerLoadI;
import com.adil.ipl.services.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @GetMapping()
    public ResponseEntity<LoadFields> getLoadFields() {

        LoadFields loadFields = loadService.getLoadFields();
        Set<BowlingTeamI> teams = loadFields.getTeams();
        for (BowlingTeamI t : teams) {
            System.out.println("TeamYO: "+t.getBowlingTeam());
        }

        return ResponseEntity.ok(loadFields);
    }
}