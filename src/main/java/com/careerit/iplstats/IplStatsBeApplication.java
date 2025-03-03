package com.careerit.iplstats;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.IplStatsDto;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.pdf.PdfService;
import com.careerit.iplstats.repo.IplStatsRepo;
import com.careerit.iplstats.repo.PlayerRepo;
import com.careerit.iplstats.service.IplStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

@SpringBootApplication
public class IplStatsBeApplication{

	@Value( "${application.boot.message}")
	private String message;

	@Autowired
	private PdfService pdfService;

	public static void main(String[] args) {
		SpringApplication.run(IplStatsBeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			pdfService.generatePdf();
		};
	}




}
