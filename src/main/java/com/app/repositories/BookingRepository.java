package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    public Booking create(Booking booking) {

    }

    public Booking findById(Long id) {

    }

    public Booking cancel(Long id) {
        
    }
}
