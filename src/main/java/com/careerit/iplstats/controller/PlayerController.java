package com.careerit.iplstats.controller;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.service.IplStatsService;
import com.careerit.iplstats.service.PlayerService;
import com.careerit.iplstats.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;


    @PostMapping("/add-all/{teamId}")
    public ApiResponse<List<Player>> addPlayers(@PathVariable("teamId") UUID teamId, @RequestBody List<Player> players) {
        return new ApiResponse<>(playerService.addPlayers(players, teamId));
    }

    @GetMapping("/all")
    public ApiResponse<List<Player>> getPlayers() {
        return new ApiResponse<>(playerService.getPlayers());
    }


}
