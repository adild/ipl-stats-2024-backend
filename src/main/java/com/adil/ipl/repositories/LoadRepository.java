package com.adil.ipl.repositories;

import com.adil.ipl.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface LoadRepository extends JpaRepository<Balls, Integer> {

    @Query(value = "SELECT DISTINCT striker FROM balls where start_date BETWEEN '2018-05-19' AND '2024-05-29'", nativeQuery = true)
    public Set<StrikerLoadI> getLoadStrikers();

    @Query(value = "SELECT DISTINCT bowler FROM balls", nativeQuery = true)
    public Set<BowlerLoadI> getLoadBowlers();
    //
    @Query(value = "SELECT DISTINCT bowling_team FROM balls", nativeQuery = true)
    public Set<BowlingTeamI> getLoadTeams();
    //
    @Query(value = "SELECT DISTINCT venue FROM balls", nativeQuery = true)
    public Set<VenueLoadI> getLoadVenues();

}