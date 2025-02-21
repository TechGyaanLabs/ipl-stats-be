package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.TeamStatsDto;

import java.util.List;

public interface IplStatsService {

    List<TeamStatsDto> getTeamStats();
}
