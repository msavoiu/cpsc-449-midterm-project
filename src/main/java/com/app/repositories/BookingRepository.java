package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    public Booking findByBookingId(Long id);
    
    // Change booking payment_status to CANCELLED
    @Modifying
    @Query("""
            UPDATE Booking b
            SET b.paymentStatus = com.app.enums.BookingStatus.CANCELLED
            WHERE b.bookingId = :id
            """)
    public int cancel(@Param("id") Long id);

    @Modifying
    @Query("""
            UPDATE TicketType tt
            SET tt.quantityAvailable = tt.quantityAvailable + 1
            WHERE tt = (
                SELECT b.ticketType
                FROM Booking b
                WHERE b.bookingId = :id
            )
            """)
    public int restoreTicketInventory(@Param("id") Long id);

    boolean existsByAttendee_AttendeeIdAndTicketType_TicketTypeId(Long attendeeId, Long ticketTypeId);
}
