package com.adil.ipl.repositories;

import com.adil.ipl.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BattingRepository extends JpaRepository<Balls, Integer> {

    /**
     * Selects batsman scores against a particular team in all his career.
     * @param striker
     * @param bowling_team
     * @return
     */
    @Query(value = "select striker, ANY_VALUE(batting_team) as BattingTeam, bowling_team as BowlingTeam, sum(runs_off_bat) as RunsOffBat, (count(ball) - COUNT(NULLIF(TRIM(wides), ''))) as Ball, ANY_VALUE(season) as Season, ANY_VALUE(start_date) as StartDate, ANY_VALUE(venue) as Venue, count(if(player_dismissed = striker, striker, NULL)) as Wickets from balls where striker=:s " +
            "AND bowling_team=:b group by match_id order by ANY_VALUE(start_date) DESC", nativeQuery = true)
    public List<BattingAgainstTeamI> getBatsmanAgainstTeam(@Param("s") String striker, @Param("b") String bowling_team);

    // Selects batsman scores against a particular venue
    @Query(value = "select striker, ANY_VALUE(batting_team) as BattingTeam, ANY_VALUE(bowling_team) as BowlingTeam, ANY_VALUE(venue) as Venue, sum(runs_off_bat) as RunsOffBat, count(ball) as Ball, ANY_VALUE(season) as Season, ANY_VALUE(start_date) as StartDate from balls where striker=:s " +
            "AND venue=:v group by match_id order by ANY_VALUE(start_date) DESC", nativeQuery = true)
    public List<BattingOnVenueI> getBatsmanAgainstVenue(@Param("s") String striker, @Param("v") String venue);

    // Selects batsman scores against a particular bowler
    @Query(value = "select striker, ANY_VALUE(batting_team) as BattingTeam, ANY_VALUE(bowler) as Bowler, ANY_VALUE(bowling_team) as BowlingTeam, ANY_VALUE(venue) as Venue, sum(runs_off_bat) as RunsOffBat, count(ball) as Ball, ANY_VALUE(season) as Season, ANY_VALUE(start_date) as StartDate, count(if(player_dismissed = striker, striker, NULL)) as Wickets from balls where striker=:s " +
            "AND bowler=:b group by match_id order by ANY_VALUE(start_date) DESC", nativeQuery = true)
    public List<BattingAgainstBowlerI> getBatsmanAgainstBowler(@Param("s") String striker, @Param("b") String bowler);

    // Batsman all last scores (implement pagination here)
    @Query(value = "select striker, ANY_VALUE(batting_team) as BattingTeam, ANY_VALUE(bowling_team) as BowlingTeam, ANY_VALUE(venue) as Venue, sum(runs_off_bat) as RunsOffBat, count(ball) as Ball, ANY_VALUE(season) as Season, ANY_VALUE(start_date) as StartDate from balls " +
            "where striker=:s group by match_id order by ANY_VALUE(start_date) DESC", nativeQuery = true)
    public List<BattingLastScoresI> getBatsmanLastScores(@Param("s") String striker);
}
