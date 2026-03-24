package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {
    @Autowired
    private AttendeeService service;

    // POST /api/attendees
    @PostMapping
    public Attendee register(@RequestBody Attendee attendee) {
        try {
            return service.registerAttendee(attendee);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // GET /api/attendees/{id}/bookings
    @GetMapping
    public List<Booking> getById(@PathVariable Long id) {
        try {
            return service.bookingsById(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
