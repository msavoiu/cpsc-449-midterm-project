package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    public Event create(Event event) {

    }

    public List<Event> findUpcoming() {

    }

    public Event findById(Long id) {

    }

    public Double findEventRevenue(Long id) {
        
    }
}
