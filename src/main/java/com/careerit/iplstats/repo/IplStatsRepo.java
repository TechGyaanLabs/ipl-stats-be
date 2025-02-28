package com.careerit.iplstats.repo;

import com.careerit.iplstats.dto.PlayerDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IplStatsRepo extends TeamDetailsRepo{

    @Query("""
             select
                new com.careerit.iplstats.dto.PlayerDto(p.id,p.name,p.role,p.country,t.label,p.price)
             from Player p
                inner join p.teamDetails t
                where t.id=:teamId
          """)
    List<PlayerDto> getPlayers(@Param("teamId") UUID teamId);
}
