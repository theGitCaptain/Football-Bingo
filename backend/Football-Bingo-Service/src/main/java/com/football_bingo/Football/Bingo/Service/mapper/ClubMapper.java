package com.football_bingo.Football.Bingo.Service.mapper;

import com.football_bingo.Football.Bingo.Service.dto.club.ClubSummaryDto;
import com.football_bingo.Football.Bingo.Service.entity.Club;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClubMapper {

    public ClubSummaryDto toSummaryDto(Club club) {
        return new ClubSummaryDto(club.getId(), club.getName());
    }

    public List<ClubSummaryDto> toSummaryDtoList(List<Club> clubs) {
        return clubs != null
                ? clubs.stream()
                    .map(this::toSummaryDto)
                    .collect(Collectors.toList())
                : Collections.emptyList();
    }
}