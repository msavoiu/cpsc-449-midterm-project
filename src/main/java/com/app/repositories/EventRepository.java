package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event WHERE e.status = com.app.enums.EventStatus.UPCOMING;")
    public List<Event> findUpcoming();

    // Find all CONFIRMED bookings for ALL ticket types belonging to the event
    // Query needs to be checked
    @Query("""
        SELECT SUM(tt.price)
        FROM Booking b
        JOIN b.TicketType tt
        WHERE tt.ticket_id IN (
            SELECT t.ticket_id FROM Event e
            JOIN e.ticket_types t WHERE e.id = :id
        )
        """)
    public Double findEventRevenue(@Param("id") Long id);
}
