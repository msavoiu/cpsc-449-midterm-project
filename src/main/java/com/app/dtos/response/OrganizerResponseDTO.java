package com.app.dtos.response;

import java.util.List;

import com.app.entities.Organizer;

public class OrganizerResponseDTO {
    private String name;
    private String email;
    private String phone;
    private List<EventResponseDTO> events;

    public OrganizerResponseDTO(Organizer organizer) {
        this.name = organizer.getName();
        this.email = organizer.getEmail();
        this.phone = organizer.getPhone();

        // Map Event to EventResponseDTO
        this.events = organizer.getEvents()
            .stream()
            .map(EventResponseDTO::new)
            .toList();
    }

    // Getters
    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public String phone() {
        return phone;
    }

    public List<EventResponseDTO> events() {
        return events;
    }
}
