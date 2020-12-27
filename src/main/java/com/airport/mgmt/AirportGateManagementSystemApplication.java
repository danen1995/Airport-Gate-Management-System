package com.airport.mgmt;

import com.airport.mgmt.domain.Flight;
import com.airport.mgmt.domain.Gate;
import com.airport.mgmt.repositories.FlightRepository;
import com.airport.mgmt.repositories.GateRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalTime;

@SpringBootApplication
public class AirportGateManagementSystemApplication {
	private final GateRepository gateRepository;
	private final FlightRepository flightRepository;

	public AirportGateManagementSystemApplication(GateRepository gateRepository, FlightRepository flightRepository) {
		this.gateRepository = gateRepository;
		this.flightRepository = flightRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(AirportGateManagementSystemApplication.class, args);
	}

	@Bean
	ApplicationRunner setup() {
		return args -> {
			Gate gateA1 = new Gate().setGateName("A1").setAvailableFrom(LocalTime.of(4,0)).setAvailableTo(LocalTime.of(6,0)).setInUse(Boolean.FALSE);
			Gate gateA2 = new Gate().setGateName("A2").setAvailableFrom(LocalTime.of(11,0)).setAvailableTo(LocalTime.of(12,0)).setInUse(Boolean.FALSE);
			Gate gateC2 = new Gate().setGateName("C2").setAvailableFrom(LocalTime.of(18,0)).setAvailableTo(LocalTime.of(22,0)).setInUse(Boolean.FALSE);
			gateRepository.save(gateA1);
			gateRepository.save(gateA2);
			gateRepository.save(gateC2);

			Flight flight1 = new Flight().setFlightNumber("F1");
			Flight flight2 = new Flight().setFlightNumber("F2");
			Flight flight3 = new Flight().setFlightNumber("F3");

			flightRepository.save(flight1);
			flightRepository.save(flight2);
			flightRepository.save(flight3);

		};
	}
}
