package com.careerit.iplstats.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;

@Service
@Slf4j
public class UtilService {


        @Scheduled(fixedDelay = 5000 * 60)
        public void showSystemDate(){
            RestClient restClient =
                    RestClient.builder()
                            .build();
            String response = restClient.get()
                    .uri("https://ipl-stats-be.onrender.com/v1/stats/greetings")
                    .retrieve()
                    .body(String.class);
            log.info("System date is {} and response {}", LocalDate.now(),response);

        }
}
