package com.bookingSystem.util;

import java.time.LocalDate;
import java.util.UUID;

import com.bookingSystem.model.Booking;

import java.time.temporal.ChronoUnit;

/**
 * Utility class for booking related operations.
 */
public class BookingUtil {

    /**
     * Generates a unique booking id.
     * @return String
     */
    public String generateBookingId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Calculates the difference betweeen checkin and checkout time
     * @param checkIn
     * @param checkOut
     * @return number of days
     */
    public long countDays(LocalDate checkIn, LocalDate checkOut){
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void printBookingDetails(Booking booking){
        System.out.println("Booking ID : " + booking.getId());
        System.out.println("Location : "+booking.getHotel().getLocation());
        System.out.println("Name : "+booking.getUser().getName());
        System.out.println("Hotel : " + booking.getHotel().getName());
        System.out.println("Room Type : " + booking.getRoom().getRoomType());
        System.out.println("Price : "+booking.getBookingAmount());
        System.out.println("Check-in : " + booking.getCheckIn());
        System.out.println("Check-out : " + booking.getCheckOut());
    }
}