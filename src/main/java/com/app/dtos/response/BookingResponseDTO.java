package com.app.dtos.response;

import java.time.LocalDateTime;

import com.app.entities.Booking;
import com.app.enums.BookingStatus;

public class BookingResponseDTO {
    private String booking_reference;
    private LocalDateTime booking_date;
    private BookingStatus payment_status;
    private String attendee_name;
    private String event_title;
    private String ticket_type_name;
    private Double price;

    public BookingResponseDTO(Booking booking) {
        this.booking_reference = booking.getBookingReference();
        this.booking_date = booking.getDate();
        this.payment_status = booking.getPaymentStatus();
        this.attendee_name = booking.getAttendee().getName();
        this.event_title = booking.getEvent().getTitle();
        this.ticket_type_name = booking.getTicketType().getName();
        this.price = booking.getTicketType().getPrice();
    }

    // Getters
    public String bookingReference() {
        return booking_reference;
    }

    public LocalDateTime bookingDate() {
        return booking_date;
    }

    public BookingStatus paymentStatus() {
        return payment_status;
    }

    public String attendeeName() {
        return attendee_name;
    }

    public String eventTitle() {
        return event_title;
    }
    
    public String ticketTypeName() {
        return ticket_type_name;
    }

    public Double price() {
        return price;
    }
}
