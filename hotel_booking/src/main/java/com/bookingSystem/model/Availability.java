package com.bookingSystem.model;

import java.time.LocalDate;

public class Availability {
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isBooked;


    public Availability(LocalDate startDate, LocalDate endDate, boolean isBooked) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isBooked = isBooked;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
}
