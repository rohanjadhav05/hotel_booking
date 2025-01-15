package com.bookingSystem.util;

import java.util.UUID;

/**
 * Utility class for booking related operations.
 */
public class BookingUtil {

    /**
     * Generates a unique booking id.
     * @return String
     */
    public static String generateBookingId() {
        return UUID.randomUUID().toString();
    }
}