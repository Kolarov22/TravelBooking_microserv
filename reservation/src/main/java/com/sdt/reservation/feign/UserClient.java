package com.sdt.reservation.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("USER-SERVICE")
public interface UserClient {
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserReservationsById(@PathVariable Long id);
}
