package com.football_bingo.Football.Bingo.Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    private Boolean enabled;

    private LocalDateTime lastIterated;

    @ManyToMany(mappedBy = "coaches")
    private List<Player> players;
}