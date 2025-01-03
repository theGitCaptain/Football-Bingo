package com.football_bingo.Football.Bingo.Service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
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

    @ManyToMany
    @JoinTable(
            name = "players_clubs",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    private List<Club> clubs;

    @ManyToMany
    @JoinTable(
            name = "players_nations",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "nation_id")
    )
    private List<Nation> citizenships;

    @ManyToMany
    @JoinTable(
            name = "players_awards",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "achievement_id")
    )
    private List<Achievement> achievements;

    @ManyToMany
    @JoinTable(
            name = "players_coaches",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "coach_id")
    )
    private List<Coach> coaches;

    @ManyToMany
    @JoinTable(
            name = "teammates",
            joinColumns = @JoinColumn(name = "player1_id"),
            inverseJoinColumns = @JoinColumn(name = "player2_id")
    )
    private List<Player> directTeammates;

    @ManyToMany
    @JoinTable(
            name = "teammates",
            joinColumns = @JoinColumn(name = "player2_id"),
            inverseJoinColumns = @JoinColumn(name = "player1_id")
    )
    private List<Player> inverseTeammates;
}