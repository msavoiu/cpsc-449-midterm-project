package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.request.VenueRequestDTO;
import com.app.dtos.response.VenueResponseDTO;
import com.app.services.VenueService;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
    @Autowired
    private VenueService service;

    // POST /api/venues
    @PostMapping
    public ResponseEntity<?> create(@RequestBody VenueRequestDTO venueReq) {
        try {
            VenueResponseDTO dto = service.createVenue(venueReq);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
