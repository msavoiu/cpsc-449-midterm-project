package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Organizer;
import com.app.repositories.OrganizerRepository;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository repo;

    public Organizer createOrganizer(Organizer organizer) {
        return repo.save(organizer);
    }
}
