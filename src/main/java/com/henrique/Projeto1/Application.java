package com.henrique.Projeto1;

import com.henrique.Projeto1.run.Location;
import com.henrique.Projeto1.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run = new Run(10,"corrida pampa", LocalDateTime.now(), LocalDateTime.now().plusHours(1),2, Location.INDOOR);
			log.info("Run" + run);
		};

	}




}
