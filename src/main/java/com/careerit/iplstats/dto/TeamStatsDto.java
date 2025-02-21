package com.careerit.iplstats.dto;

import lombok.Data;

@Data
public class TeamStatsDto {

    private String teamName;
    private String team;
    private double totalPlayers;
    private double totalAmount;
    private double maxAmount;

}
