package com.football_bingo.Football.Bingo.Service.repository;

import com.football_bingo.Football.Bingo.Service.entity.Club;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Integer> {

    @Query("SELECT c FROM Club c JOIN c.players p WHERE c.id NOT IN :excludedIds GROUP BY c.id ORDER BY COUNT(c) DESC")
    List<Club> findTopRepresentedClubs(Pageable pageable, @Param("excludedIds") List<Integer> excludedIds);
}