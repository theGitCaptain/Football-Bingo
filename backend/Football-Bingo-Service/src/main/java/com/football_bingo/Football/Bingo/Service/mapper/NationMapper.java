package com.football_bingo.Football.Bingo.Service.mapper;

import com.football_bingo.Football.Bingo.Service.dto.nation.NationSummaryDto;
import com.football_bingo.Football.Bingo.Service.entity.Nation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NationMapper {

    public NationSummaryDto toSummaryDto(Nation nation) {
        return new NationSummaryDto(nation.getId(), nation.getName());
    }

    public List<NationSummaryDto> toSummaryDtoList(List<Nation> nations) {
        return nations != null
                ? nations.stream()
                    .map(this::toSummaryDto)
                    .collect(Collectors.toList())
                : Collections.emptyList();
    }
}