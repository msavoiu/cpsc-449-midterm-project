package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private attendeeService service;

    // POST /api/bookings/{id}/cancel
    @PostMapping
    public Booking cancel(@PathVariable Long id) {
        try {
            return service.cancelBooking(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
