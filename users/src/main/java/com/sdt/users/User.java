package com.sdt.users;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    @ElementCollection
    private List<Long> reservations;

    public User() {
    }

    public User(String username, String password, List<Long> reservations) {
        this.username = username;
        this.password = password;
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getReservations() {
        return reservations;
    }

    public void setReservations(List<Long> reservations) {
        this.reservations = reservations;
    }
}
