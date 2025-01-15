package com.bookingSystem.util;

import java.time.LocalDate;
import java.util.UUID;

import com.bookingSystem.model.Room;

public class BookingUtil {
    public static String generateBookingId() {
        return UUID.randomUUID().toString();
    }

    public static double calculateTotalCost(Room room, LocalDate checkIn, LocalDate checkOut) {
        int nights = checkOut.getDayOfYear() - checkIn.getDayOfYear();
        return nights * room.getPricePerNight();
    }
}