package com.careerit.iplstats.controller;

import com.careerit.iplstats.service.TeamDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/team")
@RequiredArgsConstructor
public class TeamDetailsController {
    private final TeamDetailsService teamDetailsService;
}
