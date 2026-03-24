package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    public Venue create(Venue venue) {
        
    }
}
