package com.football_bingo.Football.Bingo.Service.mapper;

import com.football_bingo.Football.Bingo.Service.dto.city.CitySummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.foot.FootSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.player.PlayerDto;
import com.football_bingo.Football.Bingo.Service.entity.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerMapper {

    private ClubMapper clubMapper;
    private NationMapper nationMapper;
    private AchievementMapper achievementMapper;
    private CoachMapper coachMapper;
    private TeammateMapper teammateMapper;

    public PlayerDto toDto(Player player) {
        return new PlayerDto(
                player.getId(),
                player.getName(),
                player.getBirthDate(),
                player.getDeathDate(),
                player.getAge(),
                player.getImageUrl(),
                player.getBirthCity() != null ? new CitySummaryDto(player.getBirthCity().getId(), player.getBirthCity().getName()) : null,
                player.getHeight(),
                player.getIsRetired(),
                player.getFoot() != null ? new FootSummaryDto(player.getFoot().getId(), player.getFoot().getName()) : null,
                player.getShirtNumber(),
                player.getMarketValueEuros(),
                player.getEnabled(),
                player.getLastIterated(),
                clubMapper.toSummaryDtoList(player.getClubs()),
                nationMapper.toSummaryDtoList(player.getCitizenships()),
                achievementMapper.toSummaryDtoList(player.getAchievements()),
                coachMapper.toSummaryDtoList(player.getCoaches()),
                teammateMapper.toDtoList(player.getDirectTeammates(), player.getInverseTeammates())
        );
    }
}