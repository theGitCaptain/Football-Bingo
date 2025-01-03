package com.football_bingo.Football.Bingo.Service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clubs")
@NoArgsConstructor
public class Club {

    @Id
    @Column(name = "transfermarkt_id")
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "clubs")
    private List<Player> players;
}