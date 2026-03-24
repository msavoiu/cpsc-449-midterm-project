package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
