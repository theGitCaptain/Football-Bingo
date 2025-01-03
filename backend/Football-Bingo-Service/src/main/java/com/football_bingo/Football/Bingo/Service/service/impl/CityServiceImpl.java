package com.football_bingo.Football.Bingo.Service.service.impl;

import com.football_bingo.Football.Bingo.Service.dto.city.CityDto;
import com.football_bingo.Football.Bingo.Service.entity.City;
import com.football_bingo.Football.Bingo.Service.exception.ResourceNotFoundException;
import com.football_bingo.Football.Bingo.Service.mapper.CityMapper;
import com.football_bingo.Football.Bingo.Service.repository.CityRepository;
import com.football_bingo.Football.Bingo.Service.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Override
    public CityDto getCityById(Integer cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException("City does not exist with the given ID: " + cityId));

        return CityMapper.mapToDto(city);
    }
}