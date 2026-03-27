package com.app.dtos;

import com.app.entities.TicketType;

public class TicketTypeDTO {
    private String name;
    private Double price;
    private int quantityAvailable;

    public TicketTypeDTO(TicketType ticket_type) {
        this.name = ticket_type.getName();
        this.price = ticket_type.getPrice();
        this.quantityAvailable = ticket_type.getQuantityAvailable();
    }

    // Getters
    public String name() {
        return name;
    }

    public Double price() {
        return price;
    }
    
    public int quantityAvailable() {
        return quantityAvailable;
    }
}
