package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Event;
import com.app.enums.EventStatus;

public interface EventRepository extends JpaRepository<Event, Long> {
    public Event findByEventId(Long id);
    
    public List<Event> findByEventStatus(EventStatus status);

    // Find event title and all CONFIRMED bookings for ALL ticket types belonging to the event
    @Query("""
        SELECT e.title, SUM(b.ticketType.price)
        FROM Booking b
        JOIN b.event e
        WHERE b.paymentStatus = com.app.enums.BookingStatus.CONFIRMED
            AND e.eventId = :id
        GROUP BY e.title
    """)
    public List<Object[]> findEventRevenue(@Param("id") Long id);
}
