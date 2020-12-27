/*
* This code has been generated by the Rebel: a code generator for modern Java.
* 
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package com.airport.mgmt.repositories;

import com.airport.mgmt.domain.Flight;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
    Optional<Flight> findByFlightNumber(String flightNumber);
}