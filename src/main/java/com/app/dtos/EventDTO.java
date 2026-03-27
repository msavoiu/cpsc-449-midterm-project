package com.app.dtos;

import java.time.LocalDate;

import com.app.entities.Event;
import com.app.enums.EventStatus;

public class EventDTO {
    private String title;
    private String description;
    private LocalDate eventDate;
    private EventStatus eventStatus;

    public EventDTO(Event event) {
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.eventDate = event.getEventDate();
        this.eventStatus = event.getEventStatus();
    }

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
}
