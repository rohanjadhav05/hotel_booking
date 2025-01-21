package com.bookingSystem.service.inter;


import com.bookingSystem.model.Booking;
import com.bookingSystem.model.User;

/**
 * Interface for Booking Service
 */
public interface IBookingService<T extends Booking> {
    public Booking createBooking(User user, T bookAbleEntity);
}