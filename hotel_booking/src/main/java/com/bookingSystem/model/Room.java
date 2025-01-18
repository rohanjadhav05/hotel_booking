package com.bookingSystem.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a room in a hotel with a room type, price per night, and availability.
 */
public class Room {
    private String roomType;
    private double pricePerNight;
    private List<Availability> availability;

    /**
     * Constructor for Room
     * @param roomType
     * @param pricePerNight
     */
    public Room(String roomType, double pricePerNight) {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.availability = new ArrayList<>();
    }

    /**
     * Getters for room type
     * @return roomType
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Getters for price per night
     * @return pricePerNight
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Getters for availability
     * @return availability
     */
    public List<Availability> getAvailability() {
        return availability;
    }

    /**
     * Add availability to the room
     * @param startDate
     * @param endDate
     */
    public void addAvailability(LocalDate startDate, LocalDate endDate) {
        availability.add(new Availability(startDate, endDate, false));
    }
}
