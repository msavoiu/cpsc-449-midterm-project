package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.request.VenueRequestDTO;
import com.app.dtos.response.VenueResponseDTO;
import com.app.entities.Venue;
import com.app.repositories.VenueRepository;

import jakarta.transaction.Transactional;

@Service
public class VenueService {
    @Autowired
    private VenueRepository repo;

    @Transactional
    public VenueResponseDTO createVenue(VenueRequestDTO venueReq) {
        Venue venue = new Venue();
        venue.setName(venueReq.getName());
        venue.setAddress(venueReq.getAddress());
        venue.setCity(venueReq.getCity());
        venue.setTotalCapacity(venueReq.getTotalCapacity());

        Venue savedVenue = repo.save(venue);
        return new VenueResponseDTO(savedVenue);
    }
}
