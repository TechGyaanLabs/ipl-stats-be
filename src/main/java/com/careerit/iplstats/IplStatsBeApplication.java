package com.careerit.iplstats;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class IplStatsBeApplication{

	@Value( "${application.boot.message}")
	private String message;

	public static void main(String[] args) {
		SpringApplication.run(IplStatsBeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> System.out.println(message);
	}


}
