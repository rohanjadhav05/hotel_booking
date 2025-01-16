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

    /**
     * Check if the room is available for the given check-in and check-out dates
     * @param checkIn
     * @param checkOut
     * @return true if the room is available, false otherwise
     */
    public boolean isAvailable(LocalDate checkIn, LocalDate checkOut) {
        for (Availability avail : availability) {
            if ((checkIn.isAfter(avail.getStartDate()) || checkIn.equals(avail.getStartDate()))
                    && (checkOut.isBefore(avail.getEndDate()) || checkOut.equals(avail.getEndDate()))) {
                if(!avail.getIsBooked()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get the index of the availability list for the given check-in and check-out dates
     * @param checkIn
     * @param checkOut
     * @return index of the availability list
     */
    public int getIndexforAvailable(LocalDate checkIn, LocalDate checkOut){
        for (int i = 0; i <  availability.size(); i++) {
            Availability avail = availability.get(i);
            if ((checkIn.isAfter(avail.getStartDate()) || checkIn.equals(avail.getStartDate()))
                    && (checkOut.isBefore(avail.getEndDate()) || checkOut.equals(avail.getEndDate()))) {
                if(!avail.getIsBooked()) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    /**
     * Find the difference between the availability and the booking dates
     * and alter the availability list accordingly
     * @param index
     * @param bookingStart
     * @param bookingEnd
     */
    public void findDifference(int index, LocalDate bookingStart, LocalDate bookingEnd){
        Availability avail = availability.get(index);
        if (!avail.getIsBooked() && !avail.getStartDate().isAfter(bookingEnd) && !avail.getEndDate().isBefore(bookingStart)) {
            if (avail.getStartDate().isBefore(bookingStart)) {
                availability.add(new Availability(avail.getStartDate(), bookingStart.minusDays(1), false));
            }
            availability.add(new Availability(bookingStart, bookingEnd, true));
            if (avail.getEndDate().isAfter(bookingEnd)) {
                availability.add(new Availability(bookingEnd.plusDays(1), avail.getEndDate(), false));
            }
        } else {
            availability.add(avail);
        }
        availability.remove(index);
    }
}
