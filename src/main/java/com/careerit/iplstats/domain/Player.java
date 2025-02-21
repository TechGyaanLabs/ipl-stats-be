package com.careerit.iplstats.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private String country;
    private String team;
    private double price;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamDetails teamDetails;
}