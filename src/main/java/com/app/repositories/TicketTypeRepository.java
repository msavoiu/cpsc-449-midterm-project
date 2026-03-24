package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
    public Long findQuantityAvailable(Long id) {

    }

    public TicketType findById(Long id) {
        
    }
}
