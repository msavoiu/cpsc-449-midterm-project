package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
    @Autowired
    private VenueService service;

    @PostMapping
    public Venue create(Venue venue) {
        try {
            return service.createVenue(venue);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
