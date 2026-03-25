package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dtos.response.BookingResponseDTO;
import com.app.entities.Attendee;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
    public Attendee findByAttendeeId(Long id);
    
    // Get all bookings for an attendee, include event title
    @Query("""
        SELECT new com.app.dtos.response.BookingResponseDTO(b)
        FROM Booking b
        WHERE b.attendee.attendee_id = :id
    """)
    public List<BookingResponseDTO> findBookings(@Param("id") Long id);
}
