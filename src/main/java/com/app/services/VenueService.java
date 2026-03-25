package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.response.VenueResponseDTO;
import com.app.entities.Venue;
import com.app.repositories.VenueRepository;

@Service
public class VenueService {
    @Autowired
    private VenueRepository repo;

    public VenueResponseDTO createVenue(Venue venue) {
        Venue saved_venue = repo.save(venue);
        return new VenueResponseDTO(saved_venue);
    }
}
