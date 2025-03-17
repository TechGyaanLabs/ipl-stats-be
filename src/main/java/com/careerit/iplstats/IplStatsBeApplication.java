package com.careerit.iplstats;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.IplStatsDto;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.pdf.PdfService;
import com.careerit.iplstats.repo.IplStatsRepo;
import com.careerit.iplstats.repo.PlayerRepo;
import com.careerit.iplstats.service.IplStatsService;
import com.careerit.iplstats.service.PlayerService;
import com.careerit.iplstats.service.TenantDetails;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;


@SpringBootApplication
public class IplStatsBeApplication{

	@Value( "${application.boot.message}")
	private String message;

	@Value( "${spring.application.name}")
	private String appName;

	@Autowired
	private PdfService pdfService;

	@Autowired
	private IplStatsService iplStatsService;

	@Autowired
	private TenantDetails tenantDetails;


	public static void main(String[] args) {
		SpringApplication.run(IplStatsBeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			List<TenantDetails.Tenant> tenants = tenantDetails.getTenants();
			for (TenantDetails.Tenant tenant : tenants) {
				System.out.println(tenant.getTenantId()+" "+tenant.getTenantName() + " " + tenant.getIp());
			}
			// print app name
			System.out.println(appName);
		};
	}




}
