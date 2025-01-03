package com.football_bingo.Football.Bingo.Service.dto.bingo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BingoSquareDto {
    private String type;
    private String criteria;
    private Integer assignedPlayerId;
}