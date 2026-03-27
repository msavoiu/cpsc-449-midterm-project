package com.app.dtos.response;

import java.time.LocalDateTime;

import com.app.entities.Booking;
import com.app.enums.BookingStatus;

public class BookingResponseDTO {
    private String bookingReference;
    private LocalDateTime bookingDate;
    private BookingStatus paymentStatus;
    private String attendeeName;
    private String eventTitle;
    private String ticketTypeName;
    private Double price;

    public BookingResponseDTO(Booking booking) {
        this.bookingReference = booking.getBookingReference();
        this.bookingDate = booking.getDate();
        this.paymentStatus = booking.getPaymentStatus();
        this.attendeeName = booking.getAttendee().getName();
        this.eventTitle = booking.getEvent().getTitle();
        this.ticketTypeName = booking.getTicketType().getName();
        this.price = booking.getTicketType().getPrice();
    }

    // Getters
    public String getBookingReference() {
        return bookingReference;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public BookingStatus getPaymentStatus() {
        return paymentStatus;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public String getEventTitle() {
        return eventTitle;
    }
    
    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public Double getPrice() {
        return price;
    }
}
