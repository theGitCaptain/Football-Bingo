package com.football_bingo.Football.Bingo.Service.mapper;

import com.football_bingo.Football.Bingo.Service.dto.city.CityDto;
import com.football_bingo.Football.Bingo.Service.entity.City;

public class CityMapper {

    public static CityDto mapToDto(City city) {
        return new CityDto(
                city.getId(),
                city.getName()
        );
    }
}