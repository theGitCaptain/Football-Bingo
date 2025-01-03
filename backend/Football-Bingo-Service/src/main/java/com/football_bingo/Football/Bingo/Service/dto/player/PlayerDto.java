package com.football_bingo.Football.Bingo.Service.dto.player;

import com.football_bingo.Football.Bingo.Service.dto.achievement.AchievementSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.city.CitySummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.club.ClubSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.coach.CoachSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.foot.FootSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.nation.NationSummaryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    private Integer id;
    private String name;
    private Date birthDate;
    private Date deathDate;
    private Integer age;
    private String imageUrl;
    private CitySummaryDto birthCity;
    private Integer height;
    private Boolean isRetired;
    private FootSummaryDto foot;
    private Integer shirtNumber;
    private Integer marketValueEuros;
    private Boolean enabled;
    private LocalDateTime lastIterated;
    private List<ClubSummaryDto> clubs;
    private List<NationSummaryDto> citizenships;
    private List<AchievementSummaryDto> achievements;
    private List<CoachSummaryDto> coaches;
    private List<TeammateDto> teammates;
}