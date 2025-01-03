package com.football_bingo.Football.Bingo.Service.service.impl;

import com.football_bingo.Football.Bingo.Service.dto.player.PlayerDto;
import com.football_bingo.Football.Bingo.Service.entity.Player;
import com.football_bingo.Football.Bingo.Service.exception.ResourceNotFoundException;
import com.football_bingo.Football.Bingo.Service.mapper.PlayerMapper;
import com.football_bingo.Football.Bingo.Service.repository.PlayerRepository;
import com.football_bingo.Football.Bingo.Service.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    private PlayerMapper playerMapper;

    @Override
    public List<Player> getAllEnabledTeammates(Integer playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with ID: " + playerId));

        return playerRepository.findEnabledTeammates(playerId);
    }

    @Override
    public PlayerDto getPlayerById(Integer playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with ID: " + playerId));
        return playerMapper.toDto(player);
    }
}