package com.adil.ipl.repositories;

import com.adil.ipl.entities.Balls;
import com.adil.ipl.entities.GroundInfoI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroundRepository extends JpaRepository<Balls, Integer> {

    @Query(value = "select ANY_VALUE(match_id) as MatchId, innings, ANY_VALUE(batting_team) as BattingTeam, ANY_VALUE(bowling_team) as BowlingTeam,\n" +
            "sum(runs_off_bat) + sum(extras) as RunsOffBat, \n" +
            "(count(ball) - COUNT(NULLIF(TRIM(wides), ''))) as Ball, \n" +
            "ANY_VALUE(season) as Season, ANY_VALUE(start_date) as StartDate, ANY_VALUE(venue) as Venue, \n" +
            "count(if(player_dismissed = striker, striker, NULL)) as Wickets from balls where venue=:v \n" +
            "group by match_id, innings order by ANY_VALUE(start_date) DESC", nativeQuery = true)
    public List<GroundInfoI> getGroundInfo(@Param("v") String venue);



}
