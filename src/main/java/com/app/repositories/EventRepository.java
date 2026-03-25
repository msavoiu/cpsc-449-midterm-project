package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dtos.response.RevenueDTO;
import com.app.entities.Event;
import com.app.enums.EventStatus;

public interface EventRepository extends JpaRepository<Event, Long> {
    public Event findByEventId(Long id);
    
    public List<Event> findByEventStatus(EventStatus status);

    // Find event title and all CONFIRMED bookings for ALL ticket types belonging to the event
    // Query needs to be checked
    @Query("""
            SELECT e.title, SUM(tt.price)
            FROM Event e
            JOIN e.ticket_types tt
            JOIN Booking b ON b.ticket_type = tt
            WHERE b.payment_status = com.app.enums.BookingStatus.CONFIRMED
                AND e.id = :id
            GROUP BY e.title
        """)
    public RevenueDTO findEventRevenue(@Param("id") Long id);
}
