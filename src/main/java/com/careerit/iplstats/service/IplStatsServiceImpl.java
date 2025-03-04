package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.dto.*;
import com.careerit.iplstats.pdf.PdfService;
import com.careerit.iplstats.repo.IplStatsRepo;
import com.careerit.iplstats.repo.PlayerRepo;
import com.careerit.iplstats.repo.TeamDetailsRepo;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class IplStatsServiceImpl implements IplStatsService {

    private final PlayerRepo playerRepo;
    private final TeamDetailsRepo teamDetailsRepo;
    private final IplStatsRepo iplStatsRepo;
    private final PdfService pdfService;

    @Override
    public List<IplStatsDto> getTeamStats() {
        return List.of();
    }

    @Override
    public List<PlayerDto> getPlayers(UUID teamId) {
        return iplStatsRepo.getPlayers(teamId);
    }

    @Override
    public List<PlayerDto> getPlayers() {
        return iplStatsRepo.getPlayers();
    }

    @Override
    public IplStatsDto getIplStats() {

        List<TeamAmountDto> teamAmountDtos = iplStatsRepo.getTeamAmountDetails();
        List<PlayerCountDto> playerCountDtos = iplStatsRepo.getPlayerCount();
        List<CountryPlayerCountDto> countryPlayerCountDtos = iplStatsRepo.getCountryNameAndPlayersCount();

        IplStatsDto iplStatsDto = IplStatsDto
                .builder()
                .teamAmountStats(teamAmountDtos)
                .countryNameWithPlayerCountStats(countryPlayerCountDtos)
                .teamPlayerCountStats(playerCountDtos)
                .build();

        log.info("Ipl stats fetched successfully {}", iplStatsDto);
        return iplStatsDto;
    }

    @Override
    public List<PlayerDto> getTopPaidPlayers() {
        return List.of();
    }

    @Override
    public List<PlayerDto> getTopPaidPlayersOfEachTeam() {
        return List.of();
    }

    @Override
    public void downloadPlayerPdf(HttpServletResponse response) {
        
        List<PlayerDto> playerDtos = getPlayers();
        Map<String,Object> map = new HashMap<>();
        map.put("players",playerDtos);
        File file = pdfService.generatePdf(map,"player/players.xsl","root","players");
        log.info("Player pdf generated successfully at {}",file.getAbsolutePath());
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=players.pdf");
        // Write the PDF file to the response's output stream
        try (FileInputStream fis = new FileInputStream(file); OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.flush();
        }catch (IOException e){
            log.error("Error while writing the PDF file to the response's output stream",e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
}

    @Override
    public List<TeamBasicDetailsDto> getTeamBasicDetails() {
        List<TeamDetails> teamDetails = teamDetailsRepo.findAll();
        List<TeamBasicDetailsDto> teamStatsDtos = new ArrayList<>();
        teamDetails.forEach(team->{
            TeamBasicDetailsDto obj = TeamBasicDetailsDto.builder()
                    .teamId(team.getId())
                    .teamName(team.getName())
                    .teamLabel(team.getLabel())
                    .build();
            teamStatsDtos.add(obj);
        });
        return teamStatsDtos;
    }
}
