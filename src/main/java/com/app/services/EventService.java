package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.RevenueDTO;
import com.app.dtos.request.EventRequestDTO;
import com.app.dtos.response.EventResponseDTO;
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
    private EventRepository eventRepo;

    @Autowired
    private OrganizerRepository organizerRepo;

    @Autowired
    private VenueRepository venueRepo;

    @Transactional
    public EventResponseDTO createEvent(EventRequestDTO eventReq) {
        // Construct Event object to send to database
        Event event = new Event();
        event.setTitle(eventReq.getTitle());
        event.setDescription(eventReq.getDescription());
        event.setEventDate(eventReq.getEventDate());
        event.setEventStatus(eventReq.getEventStatus());

        Organizer organizer = organizerRepo.findById(eventReq.getOrganizerId())
            .orElseThrow(() -> new RuntimeException("Organizer not found"));
        Venue venue = venueRepo.findById(eventReq.getVenueId())
            .orElseThrow(() -> new RuntimeException("Venue not found"));

        event.setOrganizer(organizer);
        event.setVenue(venue);
        
        Event savedEvent = eventRepo.save(event);
        return new EventResponseDTO(savedEvent);
    }

    public List<EventResponseDTO> getUpcomingEvents() {
        return eventRepo.findByEventStatus(EventStatus.UPCOMING)
            .stream()
            .map(EventResponseDTO::new)
            .toList();
    }

    public EventResponseDTO getEvent(Long id) throws Exception {
        Event event = eventRepo.findByEventId(id);

        if (event == null) {
            throw new EntityNotFoundException("Event not found.");
        }

        return new EventResponseDTO(event);
    }

    public RevenueDTO eventRevenue(Long id) {
        List<Object[]> revenueRes = eventRepo.findEventRevenue(id);

        if (revenueRes == null || revenueRes.isEmpty()) {
            return null;
        }

        Object[] result = revenueRes.get(0);
        
        String title = (String) result[0];
        Double revenue = (Double) result[1];
        return new RevenueDTO(title, revenue);
    }
}
