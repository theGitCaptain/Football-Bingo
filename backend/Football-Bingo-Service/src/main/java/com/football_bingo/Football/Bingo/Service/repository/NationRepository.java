package com.football_bingo.Football.Bingo.Service.repository;

import com.football_bingo.Football.Bingo.Service.entity.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface NationRepository extends JpaRepository<Nation, Integer> {

    @Query("SELECT n FROM Nation n JOIN n.players p GROUP BY n.id ORDER BY COUNT(p) DESC")
    List<Nation> findTopRepresentedNations(Pageable pageable);
}