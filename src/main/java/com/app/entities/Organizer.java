package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizers")
public class Organizer {
    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY
    )
    private Long organizerId;

    @Column(name = "name",
        nullable = false, // does this mean optional?
        length = 200
    )
    private String name;

    @Column(name = "email",
        nullable = false,
        unique = true,
        length = 254
    )
    private String email;

    @Column(name = "phone",
        nullable = true,
        length = 20
    )
    private String phone;

    // Organizer -> Event relationship
    @OneToMany(mappedBy = "organizer",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.EAGER
    )
    private List<Event> events = new ArrayList<>();


    // Getters
    public Long getOrganizerId() {
        return organizerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Event> getEvents() {
        return events;
    }   

    // Setters
    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
}
}
