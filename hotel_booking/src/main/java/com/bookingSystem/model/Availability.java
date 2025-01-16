package com.bookingSystem.model;

import java.time.LocalDate;


/**
 * The Availability class represents the availability of a booking with a start date, end date, and booking status.
 */
public class Availability {
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isBooked;

    /**
     * Constructor for Availability
     * @param startDate
     * @param endDate
     * @param isBooked
     */
    public Availability(LocalDate startDate, LocalDate endDate, boolean isBooked) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isBooked = isBooked;
    }

    /**
     * Getters for start date
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Getters for end date
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }
    
    /**
     * Getters for isBooked
     * @return isBooked
     */
    public boolean getIsBooked() {
        return isBooked;
    }

    /**
     * Setters for start date
     * @param isBooked 
     */
    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
}
