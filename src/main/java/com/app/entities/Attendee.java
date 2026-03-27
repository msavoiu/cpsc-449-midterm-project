package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendees")
public class Attendee {
    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY
    )
    private Long attendeeId;

    @Column(name = "name",
        nullable = false,
        length = 200
    )
    private String name;

    @Column(name = "email",
        nullable = false,
        unique = true,
        length = 254
    )
    private String email;
    
    // Getters
    public Long getAttendeeId() {
        return attendeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    // Getters
    public void setAttendeeId(Long attendee_id) {
        this.attendeeId = attendee_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
