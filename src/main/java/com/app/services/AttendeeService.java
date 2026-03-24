package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Attendee;
import com.app.repositories.AttendeeRepository;

@Service
public class AttendeeService {
    @Autowired
    private AttendeeRepository repo;

    public List<Attendee> registerAttendee(Attendee attendee) {
        return repo.save(attendee);
    }

    public List<Booking> bookingsById(Long id) {
        return repo.findBookings(id);
    }
}
