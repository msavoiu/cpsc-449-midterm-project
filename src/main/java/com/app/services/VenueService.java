package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.entities.Venue;
import com.app.repositories.VenueRepository;

public class VenueService {
    @Autowired
    private VenueRepository repo;

    public Venue createVenue(Venue venue) {
        return repo.save(venue);
    }
}
