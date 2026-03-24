package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Attendee;
import com.app.entities.Booking;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
    // get all bookings for an attendee, use JOIN? to include event title
    // CHECK QUERY
    @Query("""
            SELECT b FROM Booking b
            LEFT JOIN b.ticket_type tt
            LEFT JOIN tt.event e
            WHERE b.attendee_id = :id
            """)
    public List<Booking> findBookings(@Param("id") Long id);
}
