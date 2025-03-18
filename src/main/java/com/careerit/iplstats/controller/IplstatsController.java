package com.careerit.iplstats.controller;

import com.careerit.iplstats.dto.IplStatsDto;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.TeamBasicDetailsDto;
import com.careerit.iplstats.service.IplStatsService;
import com.careerit.iplstats.util.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/stats")
@RequiredArgsConstructor
@Slf4j
public class IplstatsController {

    private final IplStatsService iplStatsService;


    @RequestMapping("/team-basic-details")
    public ApiResponse<List<TeamBasicDetailsDto>> getTeamBasicDetails(){
        return new ApiResponse<>(iplStatsService.getTeamBasicDetails());
    }

    @GetMapping("/players/{teamId}")
    public ApiResponse<List<PlayerDto>> getPlayers(@PathVariable("teamId") UUID teamId){
        return new ApiResponse<>(iplStatsService.getPlayers(teamId));
    }

    @GetMapping("/team-stats")
    public ApiResponse<IplStatsDto> getIplStats(){
        return new ApiResponse<>(iplStatsService.getIplStats());
    }

    @GetMapping("/download")
    public void downloadPlayersData(HttpServletResponse response){
        iplStatsService.downloadPlayerPdf(response);
    }

    public void emailPlayerDetails(){

    }
    @PostMapping("/upload")
    public ApiResponse<String> uploadPlayerDetails(@RequestParam("file") MultipartFile file){

        try {

            String tempDir = System.getProperty("java.io.tmpdir");
            String UPLOAD_DIR = tempDir + "/player-details/";
            if(!Files.exists(Paths.get(UPLOAD_DIR))){
                Files.createDirectories(Paths.get(UPLOAD_DIR));
            }
            log.info("Uploading file to {}", UPLOAD_DIR);
            // Save the file
            String filePath = UPLOAD_DIR + file.getOriginalFilename();
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            return new ApiResponse<>("File uploaded successfully: " + file.getOriginalFilename());

        } catch (IOException e) {
                    ApiResponse<String> apiresponse = new ApiResponse<String>("File upload failed:");
                    apiresponse.setSuccess(false);
                    return apiresponse;
        }
    }

    @GetMapping("/greetings")
    public String greetings(){
        return "Hello World";
    }

}
