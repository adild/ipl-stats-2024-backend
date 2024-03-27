package com.adil.ipl.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoadFields {

    private Set<StrikerLoadI> Strikers;
    private Set<BowlerLoadI> Bowlers;
    private Set<VenueLoadI> Venues;
    private Set<BowlingTeamI> Teams;

}