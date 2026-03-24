package com.app.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.app.enums.BookingStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY
    )
    private Long booking_id;

    @Column(name = "booking_reference",
        nullable = false,
        length = 20
    )
    private String booking_reference;

    @CreationTimestamp
    @Column(name = "booking_date",
        updatable = false
    )
    private LocalDateTime booking_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private BookingStatus payment_status;

    // Junction table foreign keys
    @ManyToOne
    @JoinColumn(name = "attendee_id", nullable = false)
    private Attendee attendee;
    
    @ManyToOne
    @JoinColumn(name = "ticket_type_id", nullable = false)
    private TicketType ticket_type;

    // Getters
    public TicketType ticketType() {
        return ticket_type;
    }

    public Attendee attendee() {
        return attendee;
    }

    public BookingStatus paymentStatus() {
        return payment_status;
    }
}
