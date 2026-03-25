package com.app.dtos.response;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.Event;
import com.app.enums.EventStatus;

public class EventResponseDTO {
    private Long event_id;
    private String title;
    private String description;
    private LocalDate event_date;
    private EventStatus event_status;
    private List<TicketTypeDTO> ticket_types;
    private String organizer_name;
    private String venue_name;

    public EventResponseDTO(Event event) {
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.event_date = event.getEventDate();
        this.event_status = event.getEventStatus();
        this.organizer_name = event.getOrganizer().getName();
        this.venue_name = event.getVenue().getName();

        // Map TicketType to TicketTypeDTO
        this.ticket_types = event.getTicketTypes()
            .stream()
            .map(TicketTypeDTO::new)
            .toList();
    }

    // Getters
    public Long id() {
        return event_id;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public LocalDate eventDate() {
        return event_date;
    }

    public EventStatus eventStatus() {
        return event_status;
    }

    public List<TicketTypeDTO> ticketTypes() {
        return ticket_types;
    }

    public String organizerName() {
        return organizer_name;
    }

    public String venueName() {
        return venue_name;
    }
}
