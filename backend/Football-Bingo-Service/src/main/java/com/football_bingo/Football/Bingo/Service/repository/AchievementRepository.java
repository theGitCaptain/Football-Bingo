package com.football_bingo.Football.Bingo.Service.repository;

import com.football_bingo.Football.Bingo.Service.entity.Achievement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Integer> {

    @Query("SELECT a FROM Achievement a JOIN a.players p GROUP BY a.id ORDER BY COUNT(p) DESC")
    List<Achievement> findTopRepresentedAchievements(Pageable pageable);
}