package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.enums.EventStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY
    )
    private Long eventId;

    @Column(name = "title",
        nullable = false,
        length = 100
    )
    private String title;

    @Column(name = "description",
        nullable = true,
        length = 200
    )
    private String description;

    @Column(name = "event_date",
        updatable = false
    )
    private LocalDate eventDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_status",
        nullable = false)
    private EventStatus eventStatus;

    // Event -> Ticket Type relationship
    @OneToMany(
        mappedBy = "event",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<TicketType> ticketTypes = new ArrayList<>();

    // Bi-directional relationships for accessing associated organizer and venue
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizer_id",
        nullable = false)
    private Organizer organizer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id",
        nullable = false)
    private Venue venue;


    // Getters
    public Long getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public Venue getVenue() {
        return venue;
    }

    
    // Setters
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public void setTicketTypes(List<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}