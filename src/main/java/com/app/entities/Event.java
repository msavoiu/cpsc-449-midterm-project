package com.app.entities;

import java.time.LocalDate;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY
    )
    private Long event_id;

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
    private LocalDate event_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_status",
        nullable = false)
    private EventStatus event_status;

    // Event -> Ticket Type relationship
    @OneToMany(cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "event_id")
    private List<TicketType> ticket_types;
}