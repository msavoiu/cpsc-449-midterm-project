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
    private Long attendee_id;

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
        return attendee_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
