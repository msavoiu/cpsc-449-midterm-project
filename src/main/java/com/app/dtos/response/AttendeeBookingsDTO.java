package com.app.dtos.response;

import java.util.List;

public class AttendeeBookingsDTO {
    private String attendee_name;
    private List<BookingResponseDTO> bookings;

    public AttendeeBookingsDTO(String attendee_name, List<BookingResponseDTO> bookings) {
        this.attendee_name = attendee_name;
        this.bookings = bookings;
    }

    // Getters
    String attendeeName() {
        return attendee_name;
    }

    List<BookingResponseDTO> bookings() {
        return bookings;
    }
}
