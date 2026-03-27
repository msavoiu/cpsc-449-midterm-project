package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.request.OrganizerRequestDTO;
import com.app.dtos.response.OrganizerResponseDTO;
import com.app.entities.Organizer;
import com.app.repositories.OrganizerRepository;

import jakarta.transaction.Transactional;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository repo;

    @Transactional
    public OrganizerResponseDTO createOrganizer(OrganizerRequestDTO organizerReq) {
        // Construct organizer object to put in database
        Organizer organizer = new Organizer();
        organizer.setName(organizerReq.getName());
        organizer.setEmail(organizerReq.getEmail());
        organizer.setPhone(organizerReq.getPhone());

        Organizer savedOrganizer = repo.save(organizer);
        return new OrganizerResponseDTO(savedOrganizer);
    }
}
