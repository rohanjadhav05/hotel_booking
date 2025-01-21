package com.bookingSystem.factory;

import java.time.LocalDate;

import com.bookingSystem.model.FlightBooking;
import com.bookingSystem.model.Hotel;
import com.bookingSystem.model.HotelBooking;
import com.bookingSystem.model.Room;
import com.bookingSystem.model.User;

/**
 * Implemented Factory Design Pattern
 * The BookingFactory class encapsulates the logic for creating different types of booking objects (HotelBooking and FlightBooking). 
 * This means that the client code does not need to know the details of how these objects are created.
 */
public class BookingFactory {

    /**
     * Creating HotelBooking object
     * @param user
     * @param hotel
     * @param room
     * @param checkIn
     * @param checkOut
     * @param bookingAmount
     * @return
     */
    public static HotelBooking createHotelBooking(User user, Hotel hotel, Room room, LocalDate checkIn, LocalDate checkOut, double bookingAmount) {
        return new HotelBooking(user, hotel, room, checkIn, checkOut, bookingAmount);
    }

    /**
     * Creating FlightBooking Object
     * @param user
     * @param origin
     * @param destination
     * @param departureDate
     * @param bookingAmount
     * @return
     */
    public static FlightBooking createFlightBooking(User user, String  origin, String destination, LocalDate departureDate, double bookingAmount) {
        return new FlightBooking(user, origin, destination ,departureDate, bookingAmount);
    }
}
