package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
    public List<Attendee> create() {

    }

    public List<Booking> repo.findBookings(id) {
        
    }
}
