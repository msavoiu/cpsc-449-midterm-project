package com.app.dtos.request;

import com.app.entities.Attendee;

public class AttendeeRequestDTO {
    private String name;
    private String email;

    public AttendeeRequestDTO(Attendee attendee) {
        this.name = attendee.getName();
        this.email = attendee.getEmail();
    }

    public AttendeeRequestDTO() {}

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    // Getters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
