package com.app.dtos.request;

import java.util.List;
import java.time.LocalDate;

import com.app.enums.EventStatus;

public class OrganizerRequestDTO {

    private String name;
    private String email;
    private String phone;
    private List<Long> event_ids; 


    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Long> getEvents() {
        return event_ids;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
   
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEventIds(List<Long> event_ids) {
        this.event_ids = event_ids;
    }

    // Nested DTO for events
    public static class EventDTO {
        private String title;
        private String description;
        private LocalDate eventDate;
        private EventStatus eventStatus;

        // Getters and setters
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public LocalDate getEventDate() { return eventDate; }
        public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }

        public EventStatus getEventStatus() { return eventStatus; }
        public void setEventStatus(EventStatus eventStatus) { this.eventStatus = eventStatus; }
    }
}