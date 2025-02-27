package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.dto.TeamBasicDetailsDto;
import com.careerit.iplstats.dto.TeamStatsDto;

import java.util.List;
import java.util.Map;

public interface TeamDetailsService {


        List<TeamDetails> addTeamDetails(List<TeamDetails> teamDetails);
        List<TeamDetails> getTeamDetails();
}
