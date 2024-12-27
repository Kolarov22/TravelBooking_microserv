package com.sdt.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private String hotelName;
    private String location;
    private int availableRooms;

    public Reservation() {
    }

    public Reservation(Long id, String hotelName, String location, int availableRooms) {
        this.id = id;
        this.hotelName = hotelName;
        this.location = location;
        this.availableRooms = availableRooms;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }
}
