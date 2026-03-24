package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.TicketType;

public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
    @Query()
    public Long findQuantityAvailable(Long id);
}
