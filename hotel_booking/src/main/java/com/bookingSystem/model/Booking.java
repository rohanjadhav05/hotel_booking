package com.bookingSystem.model;

import java.time.LocalDateTime;

/**
 * The Booking class represents a booking with a booking ID, user, room, hotel, check-in date, and check-out date.
 */
public abstract class Booking extends BaseEntity{
    private final User user;
    private final LocalDateTime bookindDate;
    private final double bookingAmount;

    /**
     * 
     * @param user
     */
    public Booking(User user, double bookingAmount) {
        super();
        this.user = user;
        this.bookindDate = LocalDateTime.now();
        this.bookingAmount = bookingAmount;
    }
    
    /**
     * Get the user
     * @return User Object
     */
    public User getUser() {
        return user;
    }

    /**
     * Get the Booking Date
     * @return
     */
    public LocalDateTime getBookindDate() {
        return bookindDate;
    }

    /**
     * Getters for booking amount
     * @return bookingAmount
     */
    public Double getBookingAmount() {
        return bookingAmount;
    }
}
