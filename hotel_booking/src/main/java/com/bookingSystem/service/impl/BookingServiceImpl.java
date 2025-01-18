package com.bookingSystem.service.impl;

import java.time.LocalDate;

import com.bookingSystem.model.Booking;
import com.bookingSystem.model.Hotel;
import com.bookingSystem.model.Room;
import com.bookingSystem.model.User;
import com.bookingSystem.service.inter.IBookingService;
import com.bookingSystem.util.BookingUtil;

/**
 * The BookingService class provides methods to create a new booking.
 */
public class BookingServiceImpl implements IBookingService{

    private final BookingUtil util = new BookingUtil();
    /**
     * Creates a new booking with the given user, room, hotel, check-in date, and check-out date.
     * @param user
     * @param room
     * @param hotel
     * @param checkIn
     * @param checkOut
     * @return booking object
     */
    @Override
    public Booking createBooking(User user, Room room, Hotel hotel, LocalDate checkIn, LocalDate checkOut) {
        long daysBetween = util.countDays(checkIn, checkOut);
        double bookingAmount = room.getPricePerNight() * daysBetween;
        return new Booking(user, room, hotel, bookingAmount, checkIn, checkOut);
    }


}
