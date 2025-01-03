package com.football_bingo.Football.Bingo.Service.mapper;

import com.football_bingo.Football.Bingo.Service.dto.achievement.AchievementSummaryDto;
import com.football_bingo.Football.Bingo.Service.entity.Achievement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AchievementMapper {

    public AchievementSummaryDto toSummaryDto(Achievement achievement) {
        return new AchievementSummaryDto(
                achievement.getId(),
                achievement.getName()
        );
    }

    public List<AchievementSummaryDto> toSummaryDtoList(List<Achievement> achievements) {
        return achievements != null
                ? achievements.stream()
                    .map(this::toSummaryDto)
                    .collect(Collectors.toList())
                : Collections.emptyList();
    }
}