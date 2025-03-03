package com.careerit.iplstats.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class IplStatsDto {

    private List<TeamAmountDto> teamAmountStats;
    private List<PlayerCountDto> teamPlayerCountStats;
    private List<CountryPlayerCountDto> countryNameWithPlayerCountStats;

}
