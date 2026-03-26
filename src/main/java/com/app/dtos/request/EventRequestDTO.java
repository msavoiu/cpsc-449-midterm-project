package com.app.dtos.request;

import java.time.LocalDate;

import com.app.enums.EventStatus;

public class EventRequestDTO {

    private String title;
    private String description;
    private LocalDate eventDate;
    private EventStatus eventStatus;
    private Long organizerId;
    private Long venueId;

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public Long getVenueId() {
        return venueId;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }
}