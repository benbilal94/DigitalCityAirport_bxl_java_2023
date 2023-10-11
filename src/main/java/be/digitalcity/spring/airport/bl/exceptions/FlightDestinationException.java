package be.digitalcity.spring.airport.bl.exceptions;

import lombok.Getter;

@Getter
public class FlightDestinationException extends RuntimeException {
    public FlightDestinationException() {
        super("origin and destination airport should not be the same");
    }
}
