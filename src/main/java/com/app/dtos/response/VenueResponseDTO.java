package com.app.dtos.response;

import java.util.List;

import com.app.entities.Venue;

public class VenueResponseDTO {
    private String name;
    private String address;
    private String city;
    private Long total_capacity;
    private List<EventResponseDTO> events;

    public VenueResponseDTO(Venue venue) {
        this.name = venue.getName();
        this.address = venue.getAddress();
        this.city = venue.getCity();
        this.total_capacity = venue.getTotalCapacity();

        // Map Event to EventResponseDTO
        this.events = venue.getEvents()
            .stream()
            .map(EventResponseDTO::new)
            .toList();
    }

    // Getters
    public String name() {
        return name;
    }

    public String address() {
        return address;
    }

    public String city() {
        return city;
    }

    public Long totalCapacity() {
        return total_capacity;
    }

    public List<EventResponseDTO> events() {
        return events;
    }
}
