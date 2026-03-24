package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Event;
import com.app.repositories.EventRepository;

@Service
public class EventService {
    @Autowired
    private EventRepository repo;

    public Event createEvent(Event event) {
        return repo.save(event);
    }

    public List<Event> getUpcomingEvents() {
        return repo.findUpcoming();
    }

    public Event getEvent(Long id) {
        return repo.findById(id);
    }

    public Double eventRevenue(Long id) {
        return repo.findEventRevenue(id);
    }
}
