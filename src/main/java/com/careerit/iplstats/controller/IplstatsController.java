package com.careerit.iplstats.controller;

import com.careerit.iplstats.dto.TeamBasicDetailsDto;
import com.careerit.iplstats.service.IplStatsService;
import com.careerit.iplstats.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/stats")
@RequiredArgsConstructor
public class IplstatsController {

    private final IplStatsService iplStatsService;


    @RequestMapping("/team-basic-details")
    public ApiResponse<List<TeamBasicDetailsDto>> getTeamBasicDetails(){
        return new ApiResponse<>(iplStatsService.getTeamBasicDetails());
    }


}
