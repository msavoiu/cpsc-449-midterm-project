package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    public Organizer create(Organizer organizer) {
        
    }
}
