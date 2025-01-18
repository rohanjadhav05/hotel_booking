package com.bookingSystem.service.inter;

import java.time.LocalDate;

import com.bookingSystem.model.Booking;
import com.bookingSystem.model.Hotel;
import com.bookingSystem.model.Room;
import com.bookingSystem.model.User;

/**
 * Interface for Booking Service
 */
public interface IBookingService{
    public Booking createBooking(User user, Room room, Hotel hotel, LocalDate checkIn, LocalDate checkOut);
}