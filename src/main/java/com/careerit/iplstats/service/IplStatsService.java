package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.TeamBasicDetailsDto;
import com.careerit.iplstats.dto.TeamStatsDto;

import java.util.List;
import java.util.UUID;

public interface IplStatsService {
    List<TeamBasicDetailsDto> getTeamBasicDetails();
    List<TeamStatsDto> getTeamStats();
    List<PlayerDto> getPlayers(UUID teamId);
}
