package com.football_bingo.Football.Bingo.Service.mapper;

import com.football_bingo.Football.Bingo.Service.dto.competition.CompetitionSummaryDto;
import com.football_bingo.Football.Bingo.Service.entity.Competition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompetitionMapper {

    public CompetitionSummaryDto toSummaryDto(Competition competition) {
        return new CompetitionSummaryDto(competition.getId(), competition.getName());
    }

    public List<CompetitionSummaryDto> toSummaryDtoList(List<Competition> competitions) {
        return competitions != null
                ? competitions.stream()
                    .map(this::toSummaryDto)
                    .collect(Collectors.toList())
                : Collections.emptyList();
    }
}