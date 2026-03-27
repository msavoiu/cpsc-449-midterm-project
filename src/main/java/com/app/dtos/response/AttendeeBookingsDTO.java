package com.app.dtos.response;

import java.util.List;

public class AttendeeBookingsDTO {
    private String attendeeName;
    private List<BookingResponseDTO> bookings;

    public AttendeeBookingsDTO(String attendeeName, List<BookingResponseDTO> bookings) {
        this.attendeeName = attendeeName;
        this.bookings = bookings;
    }

    // Getters
    public String getAttendeeName() {
        return attendeeName;
    }

    public List<BookingResponseDTO> getBookings() {
        return bookings;
    }
}
