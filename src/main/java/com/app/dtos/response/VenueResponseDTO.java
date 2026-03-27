package com.app.dtos.response;

import com.app.entities.Venue;

public class VenueResponseDTO {
    private String name;
    private String address;
    private String city;
    private int totalCapacity;

    public VenueResponseDTO(Venue venue) {
        this.name = venue.getName();
        this.address = venue.getAddress();
        this.city = venue.getCity();
        this.totalCapacity = venue.getTotalCapacity();

    }

    // Getters
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
}
