package com.football_bingo.Football.Bingo.Service.repository;

import com.football_bingo.Football.Bingo.Service.entity.Coach;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, Integer> {

    @Query("SELECT c FROM Coach c JOIN c.players p GROUP BY c.id ORDER BY COUNT(p) DESC")
    List<Coach> findTopRepresentedCoaches(Pageable pageable);
}