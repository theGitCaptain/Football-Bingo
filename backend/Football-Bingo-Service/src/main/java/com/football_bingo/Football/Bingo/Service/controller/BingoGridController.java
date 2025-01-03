package com.football_bingo.Football.Bingo.Service.controller;

import com.football_bingo.Football.Bingo.Service.dto.achievement.AchievementSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.bingo.BingoGridDto;
import com.football_bingo.Football.Bingo.Service.dto.club.ClubSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.coach.CoachSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.competition.CompetitionSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.nation.NationSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.player.TeammateDto;
import com.football_bingo.Football.Bingo.Service.service.BingoGridService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bingo")
@AllArgsConstructor
public class BingoGridController {

    private BingoGridService bingoGridService;

    @GetMapping("/draw-nations")
    public ResponseEntity<List<NationSummaryDto>> drawNations(
            @RequestParam(defaultValue = "10") int topPercentage,
            @RequestParam(defaultValue = "5") int drawCount) {
        List<NationSummaryDto> nations = bingoGridService.drawRandomNations(topPercentage, drawCount);
        return ResponseEntity.ok(nations);
    }

    @GetMapping("/draw-clubs")
    public ResponseEntity<List<ClubSummaryDto>> drawClubs(
            @RequestParam(defaultValue = "10") int topPercentage,
            @RequestParam(defaultValue = "5") int drawCount) {
        List<ClubSummaryDto> clubs = bingoGridService.drawRandomClubs(topPercentage, drawCount);
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/draw-competitions")
    public ResponseEntity<List<CompetitionSummaryDto>> drawCompetitions(
            @RequestParam(defaultValue = "10") int topPercentage,
            @RequestParam(defaultValue = "1") int drawCount) {
        List<CompetitionSummaryDto> competitions = bingoGridService.drawRandomCompetitions(topPercentage, drawCount);
        return ResponseEntity.ok(competitions);
    }

    @GetMapping("/draw-achievements")
    public ResponseEntity<List<AchievementSummaryDto>> drawAchievements(
            @RequestParam(defaultValue = "10") int topPercentage,
            @RequestParam(defaultValue = "3") int drawCount) {
        List<AchievementSummaryDto> achievements = bingoGridService.drawRandomAchievements(topPercentage, drawCount);
        return ResponseEntity.ok(achievements);
    }

    @GetMapping("/draw-coaches")
    public ResponseEntity<List<CoachSummaryDto>> drawCoaches(
            @RequestParam(defaultValue = "10") int topPercentage,
            @RequestParam(defaultValue = "1") int drawCount) {
        List<CoachSummaryDto> coaches = bingoGridService.drawRandomCoaches(topPercentage, drawCount);
        return ResponseEntity.ok(coaches);
    }

    @GetMapping("/draw-teammate-with")
    public ResponseEntity<List<TeammateDto>> drawTeammateWith(
            @RequestParam(defaultValue = "10") int topPercentage,
            @RequestParam(defaultValue = "1") int drawCount) {
        List<TeammateDto> teammateWithPlayers = bingoGridService.drawRandomTeammateWith(topPercentage, drawCount);
        return ResponseEntity.ok(teammateWithPlayers);
    }

    @GetMapping("/generate-grid")
    public ResponseEntity<BingoGridDto> generateGrid() {
        return ResponseEntity.ok(bingoGridService.generateBingoGrid());
    }
}