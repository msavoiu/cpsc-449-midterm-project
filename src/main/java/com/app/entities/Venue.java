package com.app.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "venues")
public class Venue {
    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY
    )
    private Long venue_id;

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
    private Long total_capacity;

    // Venue -> Event relationship
    @OneToMany(cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "venue_id")
    private List<Event> events;


    // Getters
    public Long getVenueId() {
        return venue_id;
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

    public Long getTotalCapacity() {
        return total_capacity;
    }

    public List<Event> getEvents() {
        return events;
    }
}
