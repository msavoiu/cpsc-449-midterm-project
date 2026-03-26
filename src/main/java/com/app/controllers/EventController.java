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

import com.app.dtos.request.EventRequestDTO;
import com.app.dtos.response.EventResponseDTO;
import com.app.dtos.response.RevenueDTO;
import com.app.services.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService service;

    // POST /api/events
    @PostMapping
    public ResponseEntity<?> create(@RequestBody EventRequestDTO event_req) {
        try {
            EventResponseDTO dto = service.createEvent(event_req);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // GET /api/events (upcoming only)
    @GetMapping
    public ResponseEntity<?> getUpcoming() {
        try {
            List<EventResponseDTO> dto = service.getUpcomingEvents();
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // GET /api/events/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            EventResponseDTO dto = service.getEvent(id);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // GET /api/events/{id}/revenue
    @GetMapping("/{id}/revenue")
    public ResponseEntity<?> revenue(@PathVariable Long id) {
        try {
            RevenueDTO dto = service.eventRevenue(id);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
