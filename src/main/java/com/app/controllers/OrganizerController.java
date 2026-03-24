package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {
    @Autowired
    private OrganizerService service;

    @PostMapping
    public Organizer create(Organizer organizer) {
        try {
            return service.createOrganizer(organizer);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
