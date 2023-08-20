package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/*
		@Bean
		CommandLineRunner runner(FlightsRepository flightsRepository, AirportsRepository airportsRepository){

			LocalDateTime depDate = LocalDateTime.of(2023, 8, 20, 15, 30);
			LocalDateTime retDate = LocalDateTime.of(2023, 9, 12, 18, 15);

			return args -> {
				Flights flights = new Flights(
						"Sabiha",
						"Dalaman",
						depDate,
						retDate,
						3000.0,
						LocalDateTime.now()
				);

				Airports airport = new Airports(
						"Ankara",
						LocalDateTime.now()
				);

				flightsRepository.insert(flights);
				airportsRepository.insert(airport);
			};
		}
	*/
}
