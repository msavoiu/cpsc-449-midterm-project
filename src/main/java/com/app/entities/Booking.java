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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY
    )
    private Long bookingId;

    @Column(name = "booking_reference",
        nullable = true,
        length = 20
    )
    private String bookingReference;

    @CreationTimestamp
    @Column(name = "booking_date",
        updatable = false
    )
    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private BookingStatus paymentStatus;

   // Event foreign key
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    // Junction table foreign keys
    @ManyToOne
    @JoinColumn(name = "attendee_id", nullable = false)
    private Attendee attendee;
    
    @ManyToOne
    @JoinColumn(name = "ticket_type_id", nullable = false)
    private TicketType ticketType;

    // Getters
    public Long getBookingId() {
        return bookingId;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public LocalDateTime getDate() {
        return bookingDate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public Event getEvent() {
        return event;
    }

    public Attendee getAttendee() {
        return attendee;
    }

    public BookingStatus getPaymentStatus() {
        return paymentStatus;
    }

    // Setters
        public void setBookingId(Long bookingId) {
            this.bookingId = bookingId;
        }

        public void setBookingReference(String bookingReference) {
            this.bookingReference = bookingReference;
        }

        public void setDate(LocalDateTime bookingDate) {
            this.bookingDate = bookingDate;
        }

        public void setTicketType(TicketType ticketType) {
            this.ticketType = ticketType;
        }

        public void setEvent(Event event) {
            this.event = event;
        }

        public void setAttendee(Attendee attendee) {
            this.attendee = attendee;
        }

        public void setPaymentStatus(BookingStatus paymentStatus) {
            this.paymentStatus = paymentStatus;
        }
}
