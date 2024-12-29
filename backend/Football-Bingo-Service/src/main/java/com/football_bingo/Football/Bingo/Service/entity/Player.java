package com.football_bingo.Football.Bingo.Service.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "transfermarkt_id")
    private Integer id;

    private String name;

    private Date birthDate;

    private Date deathDate;

    private Integer age;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "birth_city_id")
    private City birthCity;

    private Integer height;

    private Boolean isRetired;

    @ManyToOne
    @JoinColumn(name = "foot_id")
    private Foot foot;

    private Integer shirtNumber;

    private Integer marketValueEuros;

    private Boolean enabled;

    private LocalDateTime lastIterated;
}