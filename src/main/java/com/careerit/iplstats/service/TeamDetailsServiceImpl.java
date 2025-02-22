package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.repo.TeamDetailsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamDetailsServiceImpl implements TeamDetailsService {

    private final TeamDetailsRepo teamDetailsRepo;

    @Override
    public List<TeamDetails> addTeamDetails(List<TeamDetails> teamDetails) {
        log.info("Total teams to save: {}", teamDetails.size());
        List<TeamDetails> list = teamDetailsRepo.saveAll(teamDetails);
        log.info("Total teams saved: {}", list.size());
        return list;
    }

    @Override
    public List<TeamDetails> getTeamDetails() {
        List<TeamDetails> list = teamDetailsRepo.findAll();
        log.info("Total teams fetched: {}", list.size());
        return list;
    }
}
