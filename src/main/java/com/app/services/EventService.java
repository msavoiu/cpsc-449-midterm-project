package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.request.EventRequestDTO;
import com.app.dtos.response.EventResponseDTO;
import com.app.dtos.response.RevenueDTO;
import com.app.entities.Event;
import com.app.entities.Organizer;
import com.app.entities.Venue;
import com.app.enums.EventStatus;
import com.app.repositories.EventRepository;
import com.app.repositories.OrganizerRepository;
import com.app.repositories.VenueRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EventService {
    @Autowired
    private EventRepository event_repo;
    private OrganizerRepository organizer_repo;
    private VenueRepository venue_repo;

    @Transactional
    public EventResponseDTO createEvent(EventRequestDTO event_req) {
        // Construct Event object to send to database
        Event event = new Event();
        event.setTitle(event_req.getTitle());
        event.setDescription(event_req.getDescription());
        event.setEventDate(event_req.getEventDate());
        event.setEventStatus(event_req.getEventStatus());

        Organizer organizer = organizer_repo.findById(event_req.getOrganizerId())
            .orElseThrow(() -> new RuntimeException("Organizer not found"));
        Venue venue = venue_repo.findById(event_req.getVenueId())
            .orElseThrow(() -> new RuntimeException("Venue not found"));

        event.setOrganizer(organizer);
        event.setVenue(venue);
        
        Event saved_event = event_repo.save(event);
        return new EventResponseDTO(saved_event);
    }

    public List<EventResponseDTO> getUpcomingEvents() {
        return event_repo.findByEventStatus(EventStatus.UPCOMING)
            .stream()
            .map(EventResponseDTO::new)
            .toList();
    }

    public EventResponseDTO getEvent(Long id) throws Exception {
        Event event = event_repo.findByEventId(id);

        if (event == null) {
            throw new EntityNotFoundException("Event not found.");
        }

        return new EventResponseDTO(event);
    }

    public RevenueDTO eventRevenue(Long id) {
        return event_repo.findEventRevenue(id);
    }
}
