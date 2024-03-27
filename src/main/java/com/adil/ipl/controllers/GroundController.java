package com.adil.ipl.controllers;

import com.adil.ipl.entities.GroundInfoI;
import com.adil.ipl.services.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ground")
public class GroundController {

    @Autowired
    private GroundService groundService;

    @GetMapping("/groundInfo/{venue}")
    public ResponseEntity<List<GroundInfoI>> getGroundController(@PathVariable String venue) {

        List<GroundInfoI> groundInfo = groundService.getGroundInfo(venue);
        return ResponseEntity.ok(groundInfo);

    }

}
