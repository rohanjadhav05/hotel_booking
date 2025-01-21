package com.bookingSystem.service.impl;

import java.time.LocalDate;

import com.bookingSystem.model.Booking;
import com.bookingSystem.model.HotelBooking;
import com.bookingSystem.model.Room;
import com.bookingSystem.model.User;
import com.bookingSystem.service.inter.IBookingService;
import com.bookingSystem.util.BookingUtil;

/**
 * The BookingService class provides methods to create a new booking.
 */
public class HotelBookingServiceImpl<T extends Booking> implements IBookingService<HotelBooking>{

    private final BookingUtil util = new BookingUtil();
    
    @Override
    public Booking createBooking(User user, HotelBooking bookAbleEntity) {
        Room room = bookAbleEntity.getRoom();
        LocalDate checkIn = bookAbleEntity.getCheckIn();
        LocalDate checkOut = bookAbleEntity.getCheckOut();
        long daysBetween = util.countDays(checkIn, checkOut);
        double bookingAmount = room.getPricePerNight() * daysBetween;
        return new HotelBooking(user, bookAbleEntity.getHotel(), room, checkIn, checkOut, bookingAmount);
    }
}
