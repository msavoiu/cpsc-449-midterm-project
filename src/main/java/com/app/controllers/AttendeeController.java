package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.response.AttendeeBookingsDTO;
import com.app.dtos.response.AttendeeResponseDTO;
import com.app.entities.Attendee;
import com.app.services.AttendeeService;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {
    @Autowired
    private AttendeeService service;

    // POST /api/attendees
    @PostMapping
    public ResponseEntity<?> register(@RequestBody Attendee attendee) {
        try {
            AttendeeResponseDTO dto = service.registerAttendee(attendee);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // GET /api/attendees/{id}/bookings
    @GetMapping("/{id}/bookings")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            AttendeeBookingsDTO dto = service.bookingsById(id);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
