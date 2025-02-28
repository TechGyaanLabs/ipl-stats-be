package com.careerit.iplstats.dto;

import lombok.Data;

import java.util.Map;

@Data
public class IplStatsDto {

    private Map<String,Double> teamAmountStats;
    private Map<String,Long> teamRoleCountStats;
    private Map<String,Long> countryPlayerCountStats;

}
