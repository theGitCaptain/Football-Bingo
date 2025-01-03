package com.football_bingo.Football.Bingo.Service.repository;

import com.football_bingo.Football.Bingo.Service.entity.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;


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

    @Query("""
        SELECT COUNT(DISTINCT p.id)
        FROM Player p
        LEFT JOIN p.directTeammates dt ON dt.enabled = true
        LEFT JOIN p.inverseTeammates it ON it.enabled = true
        WHERE p.enabled = true AND (dt.id IS NOT NULL OR it.id IS NOT NULL)
    """)
    int countEligibleTeammates();

    @Query("""
        SELECT p
        FROM Player p
        LEFT JOIN p.directTeammates dt ON dt.enabled = true
        LEFT JOIN p.inverseTeammates it ON it.enabled = true
        WHERE p.enabled = true
        GROUP BY p.id
        ORDER BY (COUNT(DISTINCT dt) + COUNT(DISTINCT it)) DESC
    """)
    List<Player> findTopRepresentedTeammates(Pageable pageable);

    @Query("""
        SELECT p FROM Player p
        JOIN p.clubs c
        WHERE c.name = :clubName AND p.id NOT IN :usedPlayerIds AND p.enabled = true
        ORDER BY RAND()
        LIMIT 1
    """)
    Optional<Player> findPlayerByClub(@Param("clubName") String clubName, @Param("usedPlayerIds") Set<Integer> usedPlayerIds);

    @Query("""
        SELECT p FROM Player p
        JOIN p.citizenships n
        WHERE n.name = :nationName AND p.id NOT IN :usedPlayerIds AND p.enabled = true
        ORDER BY RAND()
        LIMIT 1
    """)
    Optional<Player> findPlayerByNation(@Param("nationName") String nationName, @Param("usedPlayerIds") Set<Integer> usedPlayerIds);

    @Query("""
        SELECT p FROM Player p
        JOIN p.achievements a
        WHERE a.name = :achievementName AND p.id NOT IN :usedPlayerIds AND p.enabled = true
        ORDER BY RAND()
        LIMIT 1
    """)
    Optional<Player> findPlayerByAchievement(@Param("achievementName") String achievementName, @Param("usedPlayerIds") Set<Integer> usedPlayerIds);

    @Query("""
        SELECT p FROM Player p
        JOIN p.competitions c
        WHERE c.name = :competitionName AND p.id NOT IN :usedPlayerIds AND p.enabled = true
        ORDER BY RAND()
        LIMIT 1
    """)
    Optional<Player> findPlayerByCompetition(@Param("competitionName") String competitionName, @Param("usedPlayerIds") Set<Integer> usedPlayerIds);

    @Query("""
        SELECT p FROM Player p
        JOIN p.coaches c
        WHERE c.name = :coachName AND p.id NOT IN :usedPlayerIds AND p.enabled = true
        ORDER BY RAND()
        LIMIT 1
    """)
    Optional<Player> findPlayerByCoach(@Param("coachName") String coachName, @Param("usedPlayerIds") Set<Integer> usedPlayerIds);

    @Query("""
        SELECT p FROM Player p
        WHERE p.id NOT IN :usedPlayerIds AND p.enabled = true
        AND (
            EXISTS (
                SELECT 1 FROM Player pt
                JOIN pt.directTeammates dt
                WHERE dt.name = :teammateName AND pt.id = p.id
            )
            OR EXISTS (
                SELECT 1 FROM Player pt
                JOIN pt.inverseTeammates it
                WHERE it.name = :teammateName AND pt.id = p.id
            )
        )
        ORDER BY RAND()
        LIMIT 1
    """)
    Optional<Player> findPlayerByTeammate(@Param("teammateName") String teammateName, @Param("usedPlayerIds") Set<Integer> usedPlayerIds);

    @Query("""
        SELECT p FROM Player p
        WHERE p.enabled = true AND p.id NOT IN :usedPlayerIds
        ORDER BY RAND()
    """)
    List<Player> findRandomEnabledPlayersNotIn(@Param("usedPlayerIds") Set<Integer> usedPlayerIds, Pageable pageable);
}