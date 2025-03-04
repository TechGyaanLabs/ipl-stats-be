package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.TeamBasicDetailsDto;
import com.careerit.iplstats.dto.IplStatsDto;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.UUID;

public interface IplStatsService {
    List<TeamBasicDetailsDto> getTeamBasicDetails();
    List<IplStatsDto> getTeamStats();
    List<PlayerDto> getPlayers(UUID teamId);
    List<PlayerDto> getPlayers();
    IplStatsDto getIplStats();
    List<PlayerDto> getTopPaidPlayers();
    List<PlayerDto> getTopPaidPlayersOfEachTeam();

    void downloadPlayerPdf(HttpServletResponse response);
}
