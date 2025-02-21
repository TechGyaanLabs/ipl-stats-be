package com.careerit.iplstats.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class TeamDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String team;
    private double totalAmount;
    private double remainingAmount;
    private String teamLabel;
    private double totalPlayer;
    private double overseasPlayers;

    @OneToMany(mappedBy = "teamDetails", cascade = CascadeType.ALL)
    private List<Player> players;


}

