package com.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Booking;
import com.app.enums.BookingStatus;
import com.app.repositories.BookingRepository;
import com.app.repositories.TicketTypeRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository booking_repo;
    private TicketTypeRepository ticket_type_repo;

    public Booking createBooking(Booking booking) throws Exception {
        // Check if ticket type exists and that there are enough tickets left
        if (
            ticket_type_repo.findQuantityAvailable(booking.ticketType().id()) <= 0 ||
            !ticket_type_repo.findById(booking.ticketType().id()).isPresent()
        ) {
            throw new Exception("Sorry, this ticket type is sold out.");
        }

        // Check that user hasn't booked the same ticket type before
        // CHANGE CONDITION IT'S A PLACEHOLDER RN
        if (booking.attendee().id() < 0) {
            throw new Exception("You have already booked this ticket type.");
        }

        return booking_repo.save(booking);
    }

    @Transactional
    public int cancelBooking(Long id) throws Exception {
        Optional<Booking> booking_check = booking_repo.findById(id);
        if (booking_check.isPresent()) {
            throw new Exception("This booking does not exist");
        }
        
        Booking booking = booking_check.get();
        if (booking.paymentStatus() == BookingStatus.CANCELLED) {
            throw new Exception("This booking has already been cancelled.");
        }

        booking_repo.restoreTicketInventory(id);
        return booking_repo.cancel(id);
    }
}
