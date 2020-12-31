package com.airport.mgmt.resources;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

/**
 * GateAvailabilityResource is a resource (DTO) class that serves like a wrapper class
 * for gate name and time availability for particular gate.
 */
@Data
public class GateAvailabilityResource {

    @NotNull
    private String gateName;
    @NotNull
    private LocalTime availableFrom;
    @NotNull
    private LocalTime availableTo;

}

