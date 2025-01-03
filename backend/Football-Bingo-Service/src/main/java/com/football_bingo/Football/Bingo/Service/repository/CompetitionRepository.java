package com.football_bingo.Football.Bingo.Service.repository;

import com.football_bingo.Football.Bingo.Service.entity.Competition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Integer> {

    @Query("SELECT c FROM Competition c JOIN c.players p GROUP BY c.id ORDER BY COUNT(p) DESC")
    List<Competition> findTopRepresentedCompetitions(Pageable pageable);
}