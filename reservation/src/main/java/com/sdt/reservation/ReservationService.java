package com.sdt.reservation;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByHotelName(String hotelName) {
        return reservationRepository.findReservationsByHotelName(hotelName);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public List<Reservation> getReservationsByLocation(String location) {
        return reservationRepository.findReservationsByLocation(location);
    }

    public List<Reservation> getReservationsByIds(List<Long> ids) {
        return reservationRepository.findAllById(ids);
    }


}
