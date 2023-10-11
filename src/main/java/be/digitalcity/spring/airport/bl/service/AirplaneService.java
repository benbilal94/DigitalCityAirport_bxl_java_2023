package be.digitalcity.spring.airport.bl.service;

import be.digitalcity.spring.airport.models.entity.Airplane;

import java.util.List;

public interface AirplaneService {
    Airplane getOne(Long id);

    List<Airplane> getWithSerialNumberStarts(String start);
}
