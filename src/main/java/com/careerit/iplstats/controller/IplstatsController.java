package com.careerit.iplstats.controller;

import com.careerit.iplstats.service.IplStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/stats")
@RequiredArgsConstructor
public class IplstatsController {

    private final IplStatsService iplStatsService;
}
