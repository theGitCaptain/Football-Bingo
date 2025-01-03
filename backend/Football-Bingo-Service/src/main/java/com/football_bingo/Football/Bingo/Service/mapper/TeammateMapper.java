package com.football_bingo.Football.Bingo.Service.mapper;

import com.football_bingo.Football.Bingo.Service.dto.player.TeammateDto;
import com.football_bingo.Football.Bingo.Service.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeammateMapper {

    public TeammateDto toDto(Player teammate) {
        return new TeammateDto(teammate.getId(), teammate.getName());
    }

    public List<TeammateDto> toDtoList(List<Player> directTeammates, List<Player> inverseTeammates) {
        Set<Player> teammates = new HashSet<>();

        if (directTeammates != null) {
            teammates.addAll(directTeammates);
        }

        if (inverseTeammates != null) {
            teammates.addAll(inverseTeammates);
        }

        return teammates.stream()
                .filter(Player::getEnabled)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}