package com.blinkitclone.blinkitclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling

public class  BlinkitcloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlinkitcloneApplication.class, args);
	}

}