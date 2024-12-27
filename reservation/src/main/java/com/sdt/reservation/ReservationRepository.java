package com.sdt.reservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface ReservationRepository  extends CrudRepository<Reservation, Long> {
    @Override
    List<Reservation> findAll();
    List<Reservation> findReservationsByHotelName(String hotelName);
    List<Reservation> findReservationsByLocation(String location);
    @Override
    List<Reservation> findAllById(Iterable<Long> ids);
}
