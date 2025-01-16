package com.bookingSystem.service;

import java.time.LocalDate;

import com.bookingSystem.model.Booking;
import com.bookingSystem.model.Hotel;
import com.bookingSystem.model.Room;
import com.bookingSystem.model.User;
import com.bookingSystem.util.BookingUtil;

/**
 * The BookingService class provides methods to create a new booking.
 */
public class BookingService {

    /**
     * Creates a new booking with the given user, room, hotel, check-in date, and check-out date.
     * @param user
     * @param room
     * @param hotel
     * @param checkIn
     * @param checkOut
     * @return booking object
     */
    public Booking createBooking(User user, Room room, Hotel hotel, LocalDate checkIn, LocalDate checkOut) {
        String bookingId = BookingUtil.generateBookingId();
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(checkIn, checkOut);
        double bookingAmount = room.getPricePerNight() * daysBetween;
        return new Booking(bookingId, user, room, hotel, bookingAmount, checkIn, checkOut);
    }


}
