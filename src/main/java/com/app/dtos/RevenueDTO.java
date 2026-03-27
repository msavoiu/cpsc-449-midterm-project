package com.app.dtos;

public class RevenueDTO {
    private String eventTitle;
    private Double totalRevenue;

    public RevenueDTO(String eventTitle, Double totalRevenue) {
        this.eventTitle = eventTitle;
        this.totalRevenue = totalRevenue;
    }
    public RevenueDTO() {}
    

    // Getters
    public String getEventTitle() {
        return eventTitle;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }


    // Setters
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
