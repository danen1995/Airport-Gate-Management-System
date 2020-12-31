/*
* This code has been generated by the Rebel: a code generator for modern Java.
* 
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package com.airport.mgmt.controllers;

import com.airport.mgmt.domain.Flight;
import com.airport.mgmt.services.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Transactional
@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Returns an Flight object with assigned gate. The url argument must
     * specify a flight number.
     * <p>
     * This method assigns the gate to particular flight.
     *
     * @param  flightNumber  flight number of a flight
     * @return               flight object with assigned gate
     * @see                  Flight
     */
    @PostMapping("assignGate")
    @ResponseStatus(HttpStatus.OK)
    public Flight assignGate(@RequestParam String flightNumber) {
        log.info("Assigning gate to flight: {}", flightNumber);
        return flightService.assignGate(flightNumber);

    }

}