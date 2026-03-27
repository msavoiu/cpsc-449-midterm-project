package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(name = "ticket_types")
public class TicketType {
    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY
    )
    private Long ticketTypeId;
    
    @Column(name = "name",
        nullable = false,
        length = 200
    )
    private String name;

    @DecimalMin(value = "0.0", inclusive = true)
    @Column(name = "price")
    private Double price; // needs to be >= 0

    @Column(name = "quantity_available")
    private int quantityAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    // Getters
    public Long getTicketTypeId() {
        return ticketTypeId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public Event getEvent() {
        return event;
    }

    // Setters
    public void setTicketTypeId(Long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setEvent(Event event) {
        this.event = event;
        if (event != null && !event.getTicketTypes().contains(this)) {
        event.getTicketTypes().add(this);
    }
    }
}
