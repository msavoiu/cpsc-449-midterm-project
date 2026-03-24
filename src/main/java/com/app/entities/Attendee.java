package com.app.entities;

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
    
    // Getters
    public Long id() {
        return attendee_id;
    }
}
