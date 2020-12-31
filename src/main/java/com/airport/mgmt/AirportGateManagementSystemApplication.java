package com.airport.mgmt;

import com.airport.mgmt.domain.Account;
import com.airport.mgmt.domain.Flight;
import com.airport.mgmt.domain.Gate;
import com.airport.mgmt.domain.Role;
import com.airport.mgmt.repositories.AccountRepository;
import com.airport.mgmt.repositories.FlightRepository;
import com.airport.mgmt.repositories.GateRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalTime;
import java.util.Set;

@SpringBootApplication
public class AirportGateManagementSystemApplication {
	private final GateRepository gateRepository;
	private final FlightRepository flightRepository;
	private final AccountRepository accountRepository;
	private final PasswordEncoder passwordEncoder;

	public AirportGateManagementSystemApplication(GateRepository gateRepository, FlightRepository flightRepository, AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
		this.gateRepository = gateRepository;
		this.flightRepository = flightRepository;
		this.accountRepository = accountRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(AirportGateManagementSystemApplication.class, args);
	}

	@Bean
	ApplicationRunner setup() {
		return args -> {
			Account accountUser = new Account().setFirstName("Petar").setLastName("Peric").setUsername("pera").setPassword(passwordEncoder.encode("pera123")).setRoles(Set.of(Role.USER));
			Account accountAdmin = new Account().setFirstName("Admin").setLastName("Adminic").setUsername("admin").setPassword(passwordEncoder.encode("admin123")).setRoles(Set.of(Role.ADMIN));
			accountRepository.save(accountUser);
			accountRepository.save(accountAdmin);

			Gate gateA1 = new Gate().setGateName("A1").setAvailableFrom(LocalTime.of(0, 0)).setAvailableTo(LocalTime.of(23, 59, 59)).setInUse(Boolean.FALSE);
			Gate gateA2 = new Gate().setGateName("A2").setAvailableFrom(LocalTime.of(11, 0)).setAvailableTo(LocalTime.of(22, 0)).setInUse(Boolean.FALSE);
			Gate gateC2 = new Gate().setGateName("C2").setAvailableFrom(LocalTime.of(18, 0)).setAvailableTo(LocalTime.of(22, 0)).setInUse(Boolean.FALSE);
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
