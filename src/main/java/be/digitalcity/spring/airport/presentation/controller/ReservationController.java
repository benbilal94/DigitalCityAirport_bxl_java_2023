package be.digitalcity.spring.airport.presentation.controller;

import be.digitalcity.spring.airport.models.dto.ReservationDTO;
import be.digitalcity.spring.airport.models.entity.Reservation;
import be.digitalcity.spring.airport.models.form.ReservationForm;
import be.digitalcity.spring.airport.bl.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id:^[0-9]+$}")
    public ResponseEntity<ReservationDTO> getOne(@PathVariable long id){
        return ResponseEntity.ok( ReservationDTO.toDTO(reservationService.getOne(id)) );
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> create(@RequestBody ReservationForm form){
        Reservation reservation = reservationService.create(form.getFlightId(), form.getPassengerId());
        return ResponseEntity.ok( ReservationDTO.toDTO( reservation ) );
    }

    @PatchMapping("/{id:^[0-9]+$}/cancel")
    public ResponseEntity<?> cancel(@PathVariable long id){
        reservationService.cancel(id);
        return ResponseEntity.noContent()
                .build();
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body( ex.getMessage() );
//    }

}
