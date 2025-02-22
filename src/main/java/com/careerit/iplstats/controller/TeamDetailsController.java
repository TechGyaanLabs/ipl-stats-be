package com.careerit.iplstats.controller;

import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.service.TeamDetailsService;
import com.careerit.iplstats.service.TeamDetailsServiceImpl;
import com.careerit.iplstats.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/team")
@RequiredArgsConstructor
public class TeamDetailsController {
    private final TeamDetailsService teamDetailsService;


    @GetMapping("/all-teams")
    public ApiResponse<List<TeamDetails>> getTeamDetails() {
        List<TeamDetails> teamDetails = teamDetailsService.getTeamDetails();
        return new ApiResponse<>(teamDetails);
    }

    @PostMapping("/add-teams")
    public ApiResponse<List<TeamDetails>> addTeamDetails(@RequestBody List<TeamDetails> teamDetails) {
        List<TeamDetails> retTeamDetails = teamDetailsService.addTeamDetails(teamDetails);
        return new ApiResponse<>(retTeamDetails);
    }

}
