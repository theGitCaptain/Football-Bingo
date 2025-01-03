package com.football_bingo.Football.Bingo.Service.dto.bingo;

import com.football_bingo.Football.Bingo.Service.dto.player.PlayerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BingoGridDto {
    private List<BingoSquareDto> squares;
    private List<PlayerDto> allPlayers;
    private Map<Integer, List<Integer>> playerToSquareMap;
}