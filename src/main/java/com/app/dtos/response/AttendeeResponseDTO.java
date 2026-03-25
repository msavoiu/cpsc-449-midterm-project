package com.app.dtos.response;

import com.app.entities.Attendee;

public class AttendeeResponseDTO {
    private Long attendee_id;
    private String name;
    private String email;

    public AttendeeResponseDTO(Attendee attendee) {
        this.attendee_id = attendee.getAttendeeId();
        this.name = attendee.getName();
        this.email = attendee.getEmail();
    }

    // Getters
    public Long attendeeId() {
        return attendee_id;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }
}