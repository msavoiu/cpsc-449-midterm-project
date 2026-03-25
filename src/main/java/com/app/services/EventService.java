package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.response.EventResponseDTO;
import com.app.dtos.response.RevenueDTO;
import com.app.entities.Event;
import com.app.enums.EventStatus;
import com.app.repositories.EventRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventService {
    @Autowired
    private EventRepository repo;

    public EventResponseDTO createEvent(Event event) {
        Event saved_event = repo.save(event);
        return new EventResponseDTO(saved_event);
    }

    public List<EventResponseDTO> getUpcomingEvents() {
        return repo.findByEventStatus(EventStatus.UPCOMING)
            .stream()
            .map(EventResponseDTO::new)
            .toList();
    }

    public EventResponseDTO getEvent(Long id) throws Exception {
        Event event = repo.findByEventId(id);

        if (event == null) {
            throw new EntityNotFoundException("Event not found.");
        }

        return new EventResponseDTO(event);
    }

    public RevenueDTO eventRevenue(Long id) {
        return repo.findEventRevenue(id);
    }
}
