package com.football_bingo.Football.Bingo.Service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "competitions")
public class Competition {

    @Id
    @Column(name = "transfermarkt_id")
    private String id;

    private String name;
}