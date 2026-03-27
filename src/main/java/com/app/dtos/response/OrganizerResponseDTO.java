package com.app.dtos.response;

import java.util.List;

import com.app.dtos.EventDTO;
import com.app.entities.Organizer;

public class OrganizerResponseDTO {
    private String name;
    private String email;
    private String phone;

    public OrganizerResponseDTO(Organizer organizer) {
        this.name = organizer.getName();
        this.email = organizer.getEmail();
        this.phone = organizer.getPhone();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
