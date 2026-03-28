package com.app.entities;

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
@Table(name = "venues")
public class Venue {
    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY
    )
    private Long venueId;

    @Column(name = "name",
        nullable = false,
        length = 200
    )
    private String name;

    @Column(name = "address",
        nullable = false,
        length = 50
    )
    private String address;

    @Column(name = "city",
        nullable = false,
        length = 25
    )
    private String city;

    @Column(name = "total_capacity",
        nullable = false
    )
    private int totalCapacity;

    // Venue -> Event relationship
    @OneToMany(mappedBy = "venue",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<Event> events;

    // Getters
    public Long getVenueId() {
        return venueId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public List<Event> getEvents() {
        return events;
    }


    // Setters
    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
