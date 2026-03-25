package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.response.OrganizerResponseDTO;
import com.app.entities.Organizer;
import com.app.repositories.OrganizerRepository;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository repo;

    public OrganizerResponseDTO createOrganizer(Organizer organizer) {
        Organizer saved_organizer = repo.save(organizer);
        return new OrganizerResponseDTO(saved_organizer);
    }
}
