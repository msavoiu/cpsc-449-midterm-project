package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_types")
public class TicketType {
    
    @Column(name = "name",
        nullable = false, // does this mean optional?
        length = 200
    )
    private String name;

    @Column(name = "price")
    private Double price; // needs to be >= 0

    @Column(name = "quantity_available")
    private Long quantity_available;
}
