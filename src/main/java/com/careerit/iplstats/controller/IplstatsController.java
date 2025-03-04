package com.careerit.iplstats.controller;

import com.careerit.iplstats.dto.IplStatsDto;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.TeamBasicDetailsDto;
import com.careerit.iplstats.service.IplStatsService;
import com.careerit.iplstats.util.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/stats")
@RequiredArgsConstructor
public class IplstatsController {

    private final IplStatsService iplStatsService;


    @RequestMapping("/team-basic-details")
    public ApiResponse<List<TeamBasicDetailsDto>> getTeamBasicDetails(){
        return new ApiResponse<>(iplStatsService.getTeamBasicDetails());
    }

    @GetMapping("/players/{teamId}")
    public ApiResponse<List<PlayerDto>> getPlayers(@PathVariable("teamId") UUID teamId){
        return new ApiResponse<>(iplStatsService.getPlayers(teamId));
    }

    @GetMapping("/team-stats")
    public ApiResponse<IplStatsDto> getIplStats(){
        return new ApiResponse<>(iplStatsService.getIplStats());
    }

    @GetMapping("/download")
    public void downloadPlayersData(HttpServletResponse response){
        iplStatsService.downloadPlayerPdf(response);
    }

    public void emailPlayerDetails(){

    }

}
