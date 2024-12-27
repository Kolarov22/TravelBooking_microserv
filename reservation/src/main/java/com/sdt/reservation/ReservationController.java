package com.sdt.reservation;

import com.sdt.reservation.feign.UserClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final UserClient userClient;

    public ReservationController(ReservationService reservationService, UserClient userClient) {
        this.reservationService = reservationService;
        this.userClient = userClient;
    }

    @PostMapping("")
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservation) {
        reservationService.createReservation(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation == null) {
            return new ResponseEntity<>("Reservation not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllReservations() {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/locations/{location}")
    public ResponseEntity<?> getReservationsByLocation(@PathVariable String location) {
        return new ResponseEntity<>(reservationService.getReservationsByLocation(location), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getReservationsByUserId(@PathVariable Long userId) {

        List<Long> reservations = (List<Long>) userClient.getUserReservationsById(userId).getBody();
        if (reservations == null) {
            return new ResponseEntity<>("No reservations for this user", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reservationService.getReservationsByIds(reservations), HttpStatus.OK);
    }



}
