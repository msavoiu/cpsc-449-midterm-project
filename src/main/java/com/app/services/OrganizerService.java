package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repositories.OrganizerRespository;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRespository repo;

    public Organizer createOrganizer(Organizer organizer) {
        return repo.create(organizer);
    }
}
