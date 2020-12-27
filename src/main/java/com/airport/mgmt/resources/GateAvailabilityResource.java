package com.airport.mgmt.resources;

import lombok.Data;
import java.time.LocalTime;

@Data
public class GateAvailabilityResource {

    private String gateName;
    private LocalTime availableFrom;
    private LocalTime availableTo;

}

