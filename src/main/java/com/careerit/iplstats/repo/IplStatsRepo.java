package com.careerit.iplstats.repo;

import com.careerit.iplstats.dto.CountryPlayerCountDto;
import com.careerit.iplstats.dto.PlayerCountDto;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.TeamAmountDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
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

    @Query("""
            select new com.careerit.iplstats.dto.TeamAmountDto(t.label, sum(p.price)) from Player p inner join p.teamDetails t group by t.label
            """)
    List<TeamAmountDto> getTeamAmountDetails();

    @Query("""
            select new com.careerit.iplstats.dto.PlayerCountDto(t.label, count(p.id)) from Player p inner join p.teamDetails t group by t.label
            """)
    List<PlayerCountDto> getPlayerCount();

    @Query("""
            select new com.careerit.iplstats.dto.CountryPlayerCountDto(p.country, count(p.id)) from Player p group by p.country
            """)
    List<CountryPlayerCountDto> getCountryNameAndPlayersCount();

}
