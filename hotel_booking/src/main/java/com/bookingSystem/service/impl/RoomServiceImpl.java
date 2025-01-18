package com.bookingSystem.service.impl;
import java.time.LocalDate;
import java.util.List;

import com.bookingSystem.model.Availability;
import com.bookingSystem.model.Room;
import com.bookingSystem.service.inter.IRoomService;

public class RoomServiceImpl implements IRoomService{

    /**
     * Check if the room is available for the given check-in and check-out dates
     * @param room 
     * @param checkIn
     * @param checkOut
     * @return true if the room is available, false otherwise
     */
    public boolean isAvailable(Room room, LocalDate checkInDate, LocalDate checkOutDate){
        List<Availability> availability = room.getAvailability();
        for (Availability avail : availability) {
            if ((checkInDate.isAfter(avail.getStartDate()) || checkInDate.equals(avail.getStartDate()))
                    && (checkOutDate.isBefore(avail.getEndDate()) || checkOutDate.equals(avail.getEndDate()))) {
                if(!avail.getIsBooked()) {
                    return true;
                }
            }
        }
        return false;

    }

     /**
     * Get the index of the availability list for the given check-in and check-out dates
     * @param room
     * @param checkIn
     * @param checkOut
     * @return index of the availability list
     */
    public int getIndexforAvailable(Room room, LocalDate checkInDate, LocalDate checkOutDate){
        List<Availability> availability = room.getAvailability();
        for (int i = 0; i <  availability.size(); i++) {
            Availability avail = availability.get(i);
            if ((checkInDate.isAfter(avail.getStartDate()) || checkInDate.equals(avail.getStartDate()))
                    && (checkOutDate.isBefore(avail.getEndDate()) || checkOutDate.equals(avail.getEndDate()))) {
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
    * @param room
    * @param index
    * @param bookingStart
    * @param bookingEnd
    */
    public void findDifference(Room room, int index, LocalDate bookingStart, LocalDate bookingEnd){
        List<Availability> availability = room.getAvailability();
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