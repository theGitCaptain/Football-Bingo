package com.football_bingo.Football.Bingo.Service.service;

import com.football_bingo.Football.Bingo.Service.dto.player.PlayerDto;
import com.football_bingo.Football.Bingo.Service.entity.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllEnabledTeammates(Integer playerId);

    PlayerDto getPlayerById(Integer playerId);
}