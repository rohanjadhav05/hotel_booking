package com.bookingSystem.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomType;
    private double pricePerNight;
    private List<Availability> availability;

    public Room(String roomType, double pricePerNight) {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.availability = new ArrayList<>();
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public List<Availability> getAvailability() {
        return availability;
    }

    public void addAvailability(LocalDate startDate, LocalDate endDate) {
        availability.add(new Availability(startDate, endDate, true));
    }

    public boolean isAvailable(LocalDate checkIn, LocalDate checkOut) {
        for (Availability avail : availability) {
            if ((checkIn.isAfter(avail.getStartDate()) || checkIn.equals(avail.getStartDate()))
                    && (checkOut.isBefore(avail.getEndDate()) || checkOut.equals(avail.getEndDate()))) {
                if(avail.getIsBooked()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getIndexforAvailable(LocalDate checkIn, LocalDate checkOut){
        for (int i = 0; i <  availability.size(); i++) {
            Availability avail = availability.get(i);
            if ((checkIn.isAfter(avail.getStartDate()) || checkIn.equals(avail.getStartDate()))
                    && (checkOut.isBefore(avail.getEndDate()) || checkOut.equals(avail.getEndDate()))) {
                if(avail.getIsBooked()) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    // Get the difference between the checkIn and checkOut dates and update the availability list
    public void findDifference(int index, LocalDate bookingStart, LocalDate bookingEnd){
        Availability avail = availability.get(index);
        if (avail.getIsBooked() && !avail.getStartDate().isAfter(bookingEnd) && !avail.getEndDate().isBefore(bookingStart)) {
            if (avail.getStartDate().isBefore(bookingStart)) {
                availability.add(new Availability(avail.getStartDate(), bookingStart.minusDays(1), true));
            }
            availability.add(new Availability(bookingStart, bookingEnd, false));
            if (avail.getEndDate().isAfter(bookingEnd)) {
                availability.add(new Availability(bookingEnd.plusDays(1), avail.getEndDate(), true));
            }
        } else {
            availability.add(avail);
        }
        availability.remove(index);
    }
}
