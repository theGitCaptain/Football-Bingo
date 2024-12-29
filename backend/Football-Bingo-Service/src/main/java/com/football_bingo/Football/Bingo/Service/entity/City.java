package com.football_bingo.Football.Bingo.Service.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    @OneToMany(mappedBy = "birthCity")
    private List<Player> players;
}