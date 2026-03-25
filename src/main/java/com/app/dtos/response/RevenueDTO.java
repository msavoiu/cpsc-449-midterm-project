package com.app.dtos.response;

public class RevenueDTO {
    private String event_title;
    private Double total_revenue;

    public RevenueDTO(String event_title, Double total_revenue) {
        this.event_title = event_title;
        this.total_revenue = total_revenue;
    }

    // Getters
    public String eventTitle() {
        return event_title;
    }

    public Double totalRevenue() {
        return total_revenue;
    }
}
