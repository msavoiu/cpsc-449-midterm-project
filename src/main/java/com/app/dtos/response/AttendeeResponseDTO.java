package com.app.dtos.response;

import com.app.entities.Attendee;

public class AttendeeResponseDTO {
    private String name;
    private String email;

    public AttendeeResponseDTO(Attendee attendee) {
        this.name = attendee.getName();
        this.email = attendee.getEmail();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}