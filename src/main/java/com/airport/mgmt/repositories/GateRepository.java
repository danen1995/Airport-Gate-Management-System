/*
* This code has been generated by the Rebel: a code generator for modern Java.
* 
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package com.airport.mgmt.repositories;

import com.airport.mgmt.domain.Gate;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface GateRepository extends CrudRepository<Gate, Long> {

    List<Gate> findAllByAvailableFromLessThanEqualAndAvailableToGreaterThanEqualAndInUse(LocalTime now, LocalTime now1, boolean b);

    Optional<Gate> findByGateName(String gateName);
}