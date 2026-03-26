package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.request.BookingRequestDTO;
import com.app.dtos.response.BookingResponseDTO;
import com.app.services.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService service;

    // POST /api/bookings
    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookingRequestDTO request) {
        try {
            BookingResponseDTO dto = service.createBooking(
                request.eventTitle(),
                request.attendeeId(),
                request.ticketTypeId()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // POST /api/bookings/{id}/cancel
    @PostMapping("/{id}/v")
    public ResponseEntity<String> cancel(@PathVariable Long id) {
        try {
            service.cancelBooking(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Booking has been cancelled.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
