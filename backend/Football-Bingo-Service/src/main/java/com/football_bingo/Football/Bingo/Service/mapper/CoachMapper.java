package com.football_bingo.Football.Bingo.Service.mapper;

import com.football_bingo.Football.Bingo.Service.dto.coach.CoachSummaryDto;
import com.football_bingo.Football.Bingo.Service.entity.Coach;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CoachMapper {

    public CoachSummaryDto toSummaryDto(Coach coach) {
        return new CoachSummaryDto(coach.getId(), coach.getName());
    }

    public List<CoachSummaryDto> toSummaryDtoList(List<Coach> coaches) {
        return coaches != null
                ? coaches.stream()
                    .map(this::toSummaryDto)
                    .collect(Collectors.toList())
                : Collections.emptyList();
    }
}