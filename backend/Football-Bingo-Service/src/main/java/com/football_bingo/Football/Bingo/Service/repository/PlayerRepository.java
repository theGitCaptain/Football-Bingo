package com.football_bingo.Football.Bingo.Service.repository;

import com.football_bingo.Football.Bingo.Service.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query("SELECT p FROM Player p " +
            "WHERE p.enabled = true AND p.id IN (" +
            "    SELECT teammate.id FROM Player pt JOIN pt.directTeammates teammate " +
            "    WHERE pt.id = :playerId AND teammate.enabled = true " +
            "    UNION " +
            "    SELECT teammate.id FROM Player pt JOIN pt.inverseTeammates teammate " +
            "    WHERE pt.id = :playerId AND teammate.enabled = true" +
            ")")
    List<Player> findEnabledTeammates(@Param("playerId") Integer playerId);
}