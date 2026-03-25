package com.app.dtos.response;

import com.app.entities.TicketType;

public class TicketTypeDTO {
    private String name;
    private Double price;
    private Long quantity_available;

    TicketTypeDTO(TicketType ticket_type) {
        this.name = ticket_type.getName();
        this.price = ticket_type.getPrice();
        this.quantity_available = ticket_type.getQuantityAvailable();
    }

    // Getters
    public String name() {
        return name;
    }

    public Double price() {
        return price;
    }
    
    public Long quantityAvailable() {
        return quantity_available;
    }
}
