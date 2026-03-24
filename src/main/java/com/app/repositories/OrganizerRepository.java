package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
