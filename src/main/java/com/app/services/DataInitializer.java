package com.app.services;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Attendee;
import com.app.entities.Booking;
import com.app.entities.Event;
import com.app.entities.Organizer;
import com.app.entities.TicketType;
import com.app.entities.Venue;
import com.app.enums.BookingStatus;
import com.app.enums.EventStatus;
import com.app.repositories.AttendeeRepository;
import com.app.repositories.BookingRepository;
import com.app.repositories.EventRepository;
import com.app.repositories.OrganizerRepository;
import com.app.repositories.TicketTypeRepository;
import com.app.repositories.VenueRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OrganizerRepository organizerRepo;
    private final VenueRepository venueRepo;
    private final EventRepository eventRepo;
    private final TicketTypeRepository ticketTypeRepo;
    private final AttendeeRepository attendeeRepo;
    private final BookingRepository bookingRepo;

    public DataInitializer(
            OrganizerRepository organizerRepo,
            VenueRepository venueRepo,
            EventRepository eventRepo,
            TicketTypeRepository ticketTypeRepo,
            AttendeeRepository attendeeRepo,
            BookingRepository bookingRepo
    ) {
        this.organizerRepo = organizerRepo;
        this.venueRepo = venueRepo;
        this.eventRepo = eventRepo;
        this.ticketTypeRepo = ticketTypeRepo;
        this.attendeeRepo = attendeeRepo;
        this.bookingRepo = bookingRepo;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // Check if database has already been populated
        if (organizerRepo.count() > 0) {
            System.out.println("Data already initialized, skipping...");
            return;
        }

        // -------------------------------
        // CREATE ORGANIZERS
        // -------------------------------
        Organizer org1 = new Organizer();
        org1.setName("Tech Conference Inc");
        org1.setEmail("tech@conf.com");
        organizerRepo.save(org1);

        Organizer org2 = new Organizer();
        org2.setName("Music Mania");
        org2.setEmail("music@mania.com");
        organizerRepo.save(org2);

        // -------------------------------
        // CREATE VENUES
        // -------------------------------
        Venue venue1 = new Venue();
        venue1.setName("Grand Hall");
        venue1.setAddress("123 America Rd.");
        venue1.setCity("San Jose, CA");
        venue1.setTotalCapacity(1000);
        venueRepo.save(venue1);

        Venue venue2 = new Venue();
        venue2.setName("Open Air Arena");
        venue2.setAddress("4567 Main St.");
        venue2.setCity("Los Angeles, CA");
        venue2.setTotalCapacity(5000);
        venueRepo.save(venue2);

        // -------------------------------
        // CREATE EVENTS
        // -------------------------------
        Event event1 = new Event();
        event1.setTitle("Tech Trends 2026");
        event1.setEventStatus(EventStatus.UPCOMING);
        event1.setEventDate(LocalDate.now().plusDays(10));
        event1.setOrganizer(org1);
        event1.setVenue(venue1);
        eventRepo.save(event1);

        Event event2 = new Event();
        event2.setTitle("Summer Music Festival");
        event2.setEventStatus(EventStatus.UPCOMING);
        event2.setEventDate(LocalDate.now().plusDays(20));
        event2.setOrganizer(org2);
        event2.setVenue(venue2);
        eventRepo.save(event2);

        Event event3 = new Event();
        event3.setTitle("Summer Music Festival");
        event3.setEventStatus(EventStatus.CANCELLED);
        event3.setEventDate(LocalDate.now().plusDays(30));
        event3.setOrganizer(org1);
        event3.setVenue(venue2);
        eventRepo.save(event3);

        // -------------------------------
        // CREATE TICKET TYPES
        // -------------------------------
        TicketType tt1 = new TicketType();
        tt1.setName("General Admission");
        tt1.setPrice(99.99);
        tt1.setQuantityAvailable(100);
        tt1.setEvent(event1);
        ticketTypeRepo.save(tt1);

        TicketType tt2 = new TicketType();
        tt2.setName("VIP");
        tt2.setPrice(199.99);
        tt2.setQuantityAvailable(50);
        tt2.setEvent(event1);
        ticketTypeRepo.save(tt2);

        TicketType tt3 = new TicketType();
        tt3.setName("General Admission");
        tt3.setPrice(75.00);
        tt3.setQuantityAvailable(200);
        tt3.setEvent(event2);
        ticketTypeRepo.save(tt3);

        // -------------------------------
        // CREATE ATTENDEES
        // -------------------------------
        Attendee attendee1 = new Attendee();
        attendee1.setName("Alice Smith");
        attendee1.setEmail("alice@example.com");
        attendeeRepo.save(attendee1);

        Attendee attendee2 = new Attendee();
        attendee2.setName("Bob Johnson");
        attendee2.setEmail("bob@example.com");
        attendeeRepo.save(attendee2);

        // -------------------------------
        // CREATE BOOKINGS
        // -------------------------------
        Booking booking1 = new Booking();
        booking1.setAttendee(attendee1);
        booking1.setTicketType(tt1);
        booking1.setEvent(event1);
        booking1.setPaymentStatus(BookingStatus.CONFIRMED);
        bookingRepo.save(booking1);

        Booking booking2 = new Booking();
        booking2.setAttendee(attendee2);
        booking2.setTicketType(tt2);
        booking2.setEvent(event1);
        booking2.setPaymentStatus(BookingStatus.CONFIRMED);
        bookingRepo.save(booking2);

        Booking booking3 = new Booking();
        booking3.setAttendee(attendee1);
        booking3.setTicketType(tt3);
        booking3.setEvent(event2);
        booking3.setPaymentStatus(BookingStatus.CONFIRMED);
        bookingRepo.save(booking3);

        System.out.println("Dummy data initialized.");
    }
}