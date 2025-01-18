package com.bookingSystem.service.inter;

import java.time.LocalDate;

import com.bookingSystem.model.Room;

public interface IRoomService {

    public boolean isAvailable(Room room, LocalDate checkInDate, LocalDate checkOutDate);
    public int getIndexforAvailable(Room room, LocalDate checkInDate, LocalDate checkOutDate);
    public void findDifference(Room room, int index, LocalDate bookingStart, LocalDate bookingEnd);
}    

