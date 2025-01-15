package com.bookingSystem.service;

import java.time.LocalDate;

import com.bookingSystem.model.Booking;
import com.bookingSystem.model.Hotel;
import com.bookingSystem.model.Room;
import com.bookingSystem.model.User;
import com.bookingSystem.util.BookingUtil;

public class BookingService {
    public Booking createBooking(User user, Room room, Hotel hotel, LocalDate checkIn, LocalDate checkOut) {
        String bookingId = BookingUtil.generateBookingId();
        return new Booking(bookingId, user, room, hotel, checkIn, checkOut);
    }
}
