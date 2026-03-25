package com.app.dtos.request;

public class BookingRequestDTO {
    private String event_title;
    private Long attendee_id;
    private Long ticket_type_id;

    BookingRequestDTO(String event_title, Long attendee_id, Long ticket_type_id) {
        this.event_title = event_title;
        this.attendee_id = attendee_id;
        this.ticket_type_id = ticket_type_id;
    }

    // Getters
    public String eventTitle() {
        return event_title;
    }

    public Long attendeeId() {
        return attendee_id;
    }

    public Long ticketTypeId() {
        return ticket_type_id;
    }
}
