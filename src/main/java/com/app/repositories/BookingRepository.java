package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Change booking payment_status to CANCELLED & restore ticket inventory
    @Query("""
            UPDATE Booking b
            SET b.payment_status = com.app.enums.BookingStatus.CANCELLED
            WHERE b.booking_id = :id
            """)
    public int cancel(@Param("id") Long id);

    @Query("""
            UPDATE TicketType tt
            SET tt.quantity_available = tt.quantity_available + 1
            WHERE tt = (
                SELECT b.ticket_type
                FROM Booking b
                WHERE b.booking_id = :id
            )
            """)
    public Booking restoreTicketInventory(@Param("id") Long id);
}
