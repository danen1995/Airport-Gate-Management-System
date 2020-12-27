package com.airport.mgmt.exceptions;

public class AirportException extends  RuntimeException{
    public AirportException(String errorMessage) {
        super(errorMessage);
    }
}
