package com.app.dtos.request;

public class BookingRequestDTO {
    private Long attendeeId;
    private Long ticketTypeId;

    public BookingRequestDTO(Long attendeeId, Long ticketTypeId) {
        this.attendeeId = attendeeId;
        this.ticketTypeId = ticketTypeId;
    }

    // Getters
    public Long getAttendeeId() {
        return attendeeId;
    }

    public Long getTicketTypeId() {
        return ticketTypeId;
    }
}
