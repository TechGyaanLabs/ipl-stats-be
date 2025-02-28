package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.TeamBasicDetailsDto;
import com.careerit.iplstats.dto.IplStatsDto;
import com.careerit.iplstats.repo.IplStatsRepo;
import com.careerit.iplstats.repo.PlayerRepo;
import com.careerit.iplstats.repo.TeamDetailsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IplStatsServiceImpl implements IplStatsService {

    private final PlayerRepo playerRepo;
    private final TeamDetailsRepo teamDetailsRepo;
    private final IplStatsRepo iplStatsRepo;

    @Override
    public List<IplStatsDto> getTeamStats() {
        return List.of();
    }

    @Override
    public List<PlayerDto> getPlayers(UUID teamId) {
        return iplStatsRepo.getPlayers(teamId);
    }

    @Override
    public List<IplStatsDto> getIplStats() {
        return List.of();
    }

    @Override
    public List<PlayerDto> getTopPaidPlayers() {
        return List.of();
    }

    @Override
    public List<PlayerDto> getTopPaidPlayersOfEachTeam() {
        return List.of();
    }

    @Override
    public List<TeamBasicDetailsDto> getTeamBasicDetails() {
        List<TeamDetails> teamDetails = teamDetailsRepo.findAll();
        List<TeamBasicDetailsDto> teamStatsDtos = new ArrayList<>();
        teamDetails.forEach(team->{
            TeamBasicDetailsDto obj = TeamBasicDetailsDto.builder()
                    .teamId(team.getId())
                    .teamName(team.getName())
                    .teamLabel(team.getLabel())
                    .build();
            teamStatsDtos.add(obj);
        });
        return teamStatsDtos;
    }
}
