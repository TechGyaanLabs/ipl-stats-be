package com.careerit.iplstats.controller;

import com.careerit.iplstats.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
}
