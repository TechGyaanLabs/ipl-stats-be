package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerService {
        List<Player> getPlayers();
        List<Player> addPlayers(List<Player> players, UUID teamId);
}
