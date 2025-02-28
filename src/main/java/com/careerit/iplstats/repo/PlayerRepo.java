package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.PlayerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PlayerRepo extends JpaRepository<Player, UUID> {

    @Query("select p.name from Player p where p.teamDetails.id=:teamId")
    List<String> playerNames(UUID teamId);

    @Query(value = "select * from player p where p.price <= 0.3 and p.team_id=:teamId",nativeQuery = true)
    List<Player> findBasicPaidPlayers(@Param("teamId") UUID teamId);

    List<Player> findByCountry(@Param("country") String country);

    List<Player> findByPriceBetween(@Param("min") Double min, @Param("max") Double max);

}
