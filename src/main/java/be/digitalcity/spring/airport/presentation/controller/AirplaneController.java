package be.digitalcity.spring.airport.presentation.controller;

import be.digitalcity.spring.airport.bl.service.AirplaneService;
import be.digitalcity.spring.airport.models.dto.AirplaneDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {

    private final AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @GetMapping(params = "start")
    public ResponseEntity<List<AirplaneDTO>> getAllWithSerialNumberStartsBy(@RequestParam String start){
        return ResponseEntity.ok(
                airplaneService.getWithSerialNumberStarts(start).stream()
                        .map(AirplaneDTO::toDTO)
                        .toList()
        );
    }

}
