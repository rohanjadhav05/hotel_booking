package com.bookingSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bookingSystem.model.Availability;
import com.bookingSystem.model.Hotel;
import com.bookingSystem.model.Room;

public class HotelService {
    public List<Room> searchRooms(Hotel hotel, String roomType, LocalDate checkIn, LocalDate checkOut) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : hotel.getRooms()) {
            if (room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable(checkIn, checkOut)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public List<Hotel> findHotelsByCityAndAvailability(List<Hotel> hotels, String city, LocalDate checkIn, LocalDate checkOut) {
        List<Hotel> matchingHotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getLocation().equalsIgnoreCase(city)) {
                boolean hasAvailableRoom = false;
                for (Room room : hotel.getRooms()) {
                    if (room.isAvailable(checkIn, checkOut)) {
                        hasAvailableRoom = true;
                        break;
                    }
                }
                if (hasAvailableRoom) {
                    matchingHotels.add(hotel);
                }
            }
        }
        return matchingHotels;
    }
    public List<Hotel> findAllAvailbleHotels(List<Hotel> hotel){
        List<Hotel> availableHotels = new ArrayList<>();
        for (Hotel h : hotel) {
            for(Room room : h.getRooms()){
                for(Availability avail : room.getAvailability()){
                    if(avail.getIsBooked()){
                        if(!availableHotels.contains(h)){
                            availableHotels.add(h);
                        }
                        break;
                    }
                }
            }
        }
        return availableHotels;
    }
}
