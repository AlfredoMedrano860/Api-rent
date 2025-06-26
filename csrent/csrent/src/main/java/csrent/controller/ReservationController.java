package csrent.controller;

import csrent.dto.ReservationDTO;
import csrent.model.Reservation;
import csrent.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Reservation> postReservation(@RequestBody ReservationDTO dto) {
        Reservation saved = service.add(dto); // suponiendo que lo guardas aquí
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
