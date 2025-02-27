package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.repo.PlayerRepo;
import com.careerit.iplstats.repo.TeamDetailsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepo playerRepo;
    private final TeamDetailsRepo  teamDetailsRepo;


    @Override
    public List<Player> getPlayers() {
        List<Player> players = playerRepo.findAll();
        log.info("Total players fetched: {}", players.size());
        return players;
    }

    @Override
    public List<Player> addPlayers(List<Player> players, UUID teamId) {
        TeamDetails teamDetails = teamDetailsRepo.findById(teamId).orElseThrow(()->new IllegalArgumentException("Team not found"));
        log.info("Team details found for team id {} and name :{}", teamId, teamDetails.getName());
        players.forEach(
                player ->
                        player.setTeamDetails(teamDetails));

         List<Player> savedPlayers = playerRepo.saveAll(players);
         log.info("Team {} total {} players added successfully", teamDetails.getName(), savedPlayers.size());
         return savedPlayers;
    }
}
