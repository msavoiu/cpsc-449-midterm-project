package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repositories.BookingRepository;
import com.app.repositories.TicketTypeRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository booking_repo;
    private TicketTypeRepository ticket_type_repo;

    public Booking createBooking(Booking booking) {
        // Check if ticket type exists and that there are enough tickets left
        if (
            ticket_type_repo.findQuantityAvailable(booking.ticket_type_id) <= 0 ||
            !ticket_type_repo.findById(booking.ticket_type_id)
        ) {
            throw new Exception("Sorry, this ticket type is sold out.");
        }

        // Check that user hasn't booked the same ticket type before
        if (booking.attendee_id something something) {
            throw new Exception("You have already booked this ticket type.");
        }

        return booking_repo.create(booking);
    }

    public Booking cancelBooking(Long id) {
        // Check if booking exists
        if (!repo.findById(id)) {
            throw new Exception("This booking does not exist");
        }
        // Check if booking has already been cancelled
        if (repo.findById(id).status == CANCELLED) {
            throw new Exception("This booking has already been cancelled.");
        }

        return repo.cancel(id);
    }
}
