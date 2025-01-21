package com.bookingSystem.service.impl;

import com.bookingSystem.model.Booking;
import com.bookingSystem.model.FlightBooking;
import com.bookingSystem.model.User;
import com.bookingSystem.service.inter.IBookingService;

/**
 * The BookingService class provides methods to create a new booking.
 */
public class FlightBookingServiceImpl<T extends Booking> implements IBookingService<FlightBooking>{
    
    @Override
    public Booking createBooking(User user, FlightBooking bookAbleEntity) {
        return new FlightBooking(user, bookAbleEntity.getOrigin(), bookAbleEntity.getDestination(), bookAbleEntity.getDepartureDate(), bookAbleEntity.getBookingAmount());
    }
}
