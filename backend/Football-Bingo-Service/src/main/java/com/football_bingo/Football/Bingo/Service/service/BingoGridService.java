package com.football_bingo.Football.Bingo.Service.service;

import com.football_bingo.Football.Bingo.Service.dto.achievement.AchievementSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.bingo.BingoGridDto;
import com.football_bingo.Football.Bingo.Service.dto.club.ClubSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.coach.CoachSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.competition.CompetitionSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.nation.NationSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.player.TeammateDto;

import java.util.List;

public interface BingoGridService {

    List<NationSummaryDto> drawRandomNations(int topPercentage, int drawCount);

    List<ClubSummaryDto> drawRandomClubs(int topPercentage, int drawCount);

    List<CompetitionSummaryDto> drawRandomCompetitions(int topPercentage, int drawCount);

    List<AchievementSummaryDto> drawRandomAchievements(int topPercentage, int drawCount);

    List<CoachSummaryDto> drawRandomCoaches(int topPercentage, int drawCount);

    List<TeammateDto> drawRandomTeammateWith(int topPercentage, int drawCount);

    BingoGridDto generateBingoGrid();
}