package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.repo.TeamDetailsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamDetailsServiceImpl implements TeamDetailsService {

    private final TeamDetailsRepo teamDetailsRepo;

    @Override
    public List<TeamDetails> addTeamDetails(List<TeamDetails> teamDetails) {
        return List.of();
    }
}
