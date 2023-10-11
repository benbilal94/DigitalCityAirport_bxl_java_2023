package be.digitalcity.spring.airport.bl.service;

import be.digitalcity.spring.airport.models.entity.Flight;

import java.util.List;

public interface FlightService {


    Flight getOne(long id);
    Flight create(Flight flight);

    void updatePilot(long id, long pilotId);
    void updateAirplane(long id, long airplaneId);

    List<Flight> getUserFlights(long userId, boolean seeCancelled);
}
