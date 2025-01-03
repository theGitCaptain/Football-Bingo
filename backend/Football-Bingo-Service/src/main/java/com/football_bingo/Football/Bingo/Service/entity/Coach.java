package com.football_bingo.Football.Bingo.Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "coaches")
public class Coach {

    @Id
    @Column(name = "transfermarkt_id")
    private Integer id;

    private String name;

    private String imageUrl;

    @ManyToMany(mappedBy = "coaches")
    private List<Player> playersCoached;
}