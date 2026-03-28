package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.TicketType;

public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
    public TicketType findByTicketTypeId(Long id);

    public Long findQuantityAvailableByTicketTypeId(Long id);

    @Modifying
    @Query("""
            UPDATE TicketType tt
            SET tt.quantityAvailable = tt.quantityAvailable - :decrement
            WHERE tt.ticketTypeId = :id
                AND tt.quantityAvailable >= :decrement
            """)
    public int decreaseQuantityAvailable(@Param("id") Long id, @Param("decrement") int decrement);
}
