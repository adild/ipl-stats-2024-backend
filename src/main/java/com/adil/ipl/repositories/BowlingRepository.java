package com.adil.ipl.repositories;

import com.adil.ipl.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BowlingRepository extends JpaRepository<Balls, Integer> {

    // Bowler against batting team
    @Query(value = "select bowler, ANY_VALUE(bowling_team) as BowlingTeam, batting_team as BattingTeam, sum(runs_off_bat) + sum(wides) as RunsOffBat, count(ball) as Ball, " +
            "COUNT(NULLIF(TRIM(wicket_type), '')) as Wickets, " +
            "ANY_VALUE(season) as Season, ANY_VALUE(start_date) as StartDate, ANY_VALUE(venue) as Venue from balls where bowler=:b " +
            "AND batting_team=:bat group by match_id order by ANY_VALUE(start_date) DESC", nativeQuery = true)
    public List<BowlingAgainstTeamI> getBowlingAgainstTeam(@Param("b") String bowler, @Param("bat") String battingTeam);

    // Bowler on venue
    @Query(value = "select bowler, ANY_VALUE(bowling_team) as BowlingTeam, ANY_VALUE(batting_team) as BattingTeam, ANY_VALUE(venue) as Venue, sum(runs_off_bat) + sum(wides) as RunsOffBat, count(ball) as Ball, " +
            "COUNT(NULLIF(TRIM(wicket_type), '')) as Wickets, " +
            "ANY_VALUE(season) as Season, ANY_VALUE(start_date) as StartDate from balls where bowler=:b " +
            "AND venue=:v group by match_id order by ANY_VALUE(start_date) DESC", nativeQuery = true)
    public List<BowlingOnVenueI> getBowlingOnVenue(@Param("b") String bowler, @Param("v") String venue);

    // Bowler against batsman
    @Query(value = "select bowler, ANY_VALUE(striker) as Striker, ANY_VALUE(bowling_team) as BowlingTeam, ANY_VALUE(batting_team) as BattingTeam, ANY_VALUE(venue) as Venue, sum(runs_off_bat) + sum(wides) as RunsOffBat, count(ball) as Ball, " +
            "COUNT(NULLIF(TRIM(wicket_type), '')) as Wickets, " +
            "ANY_VALUE(season) as Season, ANY_VALUE(start_date) as StartDate from balls where bowler=:bol " +
            "AND striker=:bat group by match_id order by ANY_VALUE(start_date) DESC", nativeQuery = true)
    public List<BowlingAgainstBatsmanI> getBowlerAgainstBatman(@Param("bol") String bowler, @Param("bat") String striker);


    // Bowler against all teams
    @Query(value = "select bowler, ANY_VALUE(bowling_team) as BowlingTeam, ANY_VALUE(batting_team) as BattingTeam, sum(runs_off_bat) + sum(wides) as RunsOffBat, count(ball) as Ball, " +
            "COUNT(NULLIF(TRIM(wicket_type), '')) as Wickets, " +
            "ANY_VALUE(season) as Season, ANY_VALUE(start_date) as StartDate, ANY_VALUE(venue) as Venue from balls " +
            "where bowler=:b group by match_id order by ANY_VALUE(start_date) DESC", nativeQuery = true)
    List<BowlerAgainstAllTeamI> getBowlerAgainstAllTeams(@Param("b") String bowler);

}