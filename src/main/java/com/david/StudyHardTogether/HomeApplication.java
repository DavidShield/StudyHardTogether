package com.david.StudyHardTogether;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.david.StudyHardTogether"})
public class HomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeApplication.class);
	}

}
