package com.app.dtos.response;

import java.time.LocalDate;
import java.util.List;

import com.app.dtos.TicketTypeDTO;
import com.app.entities.Event;
import com.app.enums.EventStatus;

public class EventResponseDTO {
    private String title;
    private String description;
    private LocalDate eventDate;
    private EventStatus eventStatus;
    private List<TicketTypeDTO> ticketTypes;
    private String organizerName;
    private String venueName;

    public EventResponseDTO(Event event) {
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.eventDate = event.getEventDate();
        this.eventStatus = event.getEventStatus();
        this.organizerName = event.getOrganizer().getName();
        this.venueName = event.getVenue().getName();

        // Map TicketType to TicketTypeDTO
        if (!event.getTicketTypes().isEmpty()) {
            this.ticketTypes = event.getTicketTypes()
                .stream()
                .map(TicketTypeDTO::new)
                .toList();
        }
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

    public List<TicketTypeDTO> getTicketTypes() {
        return ticketTypes;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public String getVenueName() {
        return venueName;
    }
}
