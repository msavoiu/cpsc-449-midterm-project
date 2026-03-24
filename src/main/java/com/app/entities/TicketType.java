package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_types")
public class TicketType {
    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY
    )
    private Long ticket_type_id;
    
    @Column(name = "name",
        nullable = false, // does this mean optional?
        length = 200
    )
    private String name;

    @Column(name = "price")
    private Double price; // needs to be >= 0

    @Column(name = "quantity_available")
    private Long quantity_available;

    // Getters
    public Long id() {
        return ticket_type_id;
    }
}
