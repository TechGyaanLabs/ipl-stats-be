package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.TeamDetails;

import java.util.List;

public interface TeamDetailsService {

        List<TeamDetails> addTeamDetails(List<TeamDetails> teamDetails);
        List<TeamDetails> getTeamDetails();
}
