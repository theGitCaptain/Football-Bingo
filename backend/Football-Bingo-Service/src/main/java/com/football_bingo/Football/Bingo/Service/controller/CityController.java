package com.football_bingo.Football.Bingo.Service.controller;

import com.football_bingo.Football.Bingo.Service.dto.city.CityDto;
import com.football_bingo.Football.Bingo.Service.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CityController {

    private CityService cityService;

    @GetMapping("{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable("id") Integer cityId) {
        CityDto cityDto = cityService.getCityById(cityId);
        return ResponseEntity.ok(cityDto);
    }
}