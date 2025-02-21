package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.TeamStatsDto;
import com.careerit.iplstats.repo.PlayerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IplStatsServiceImpl implements IplStatsService {

    private final PlayerRepo playerRepo;

    @Override
    public List<TeamStatsDto> getTeamStats() {
        return List.of();
    }
}
