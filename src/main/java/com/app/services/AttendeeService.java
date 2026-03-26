package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.response.AttendeeBookingsDTO;
import com.app.dtos.response.AttendeeResponseDTO;
import com.app.dtos.response.BookingResponseDTO;
import com.app.entities.Attendee;
import com.app.repositories.AttendeeRepository;

import jakarta.transaction.Transactional;

@Service
public class AttendeeService {
    @Autowired
    private AttendeeRepository repo;

    @Transactional
    public AttendeeResponseDTO registerAttendee(Attendee attendee) {
        Attendee registered_attendee = repo.save(attendee);
        return new AttendeeResponseDTO(registered_attendee);
    }

    public AttendeeBookingsDTO bookingsById(Long id) {
        Attendee attendee = repo.findByAttendeeId(id);
        List<BookingResponseDTO> booking_dtos = repo.findBookings(id);

        return new AttendeeBookingsDTO(attendee.getName(), booking_dtos);
    }
}
