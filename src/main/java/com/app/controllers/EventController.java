package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService service;

    // POST /api/events
    @PostMapping
    public Event create(@RequestBody Event event) {
        try {
            return service.createEvent(event);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // GET /api/events (filtered by UPCOMING)
    @GetMapping
    public List<Event> getUpcoming() {
        try {
            return service.getUpcomingEvents();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // GET /api/events/{id}
    @GetMapping
    public Event getById(@PathVariable Long id) {
        try {
            return service.getEvent(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // GET /api/events/{id}/revenue
    @GetMapping
    public Double revenue(@PathVariable Long id) {
        try {
            return service.eventRevenue(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
