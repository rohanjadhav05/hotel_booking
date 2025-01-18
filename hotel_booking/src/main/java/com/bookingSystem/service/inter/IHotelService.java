package com.bookingSystem.service.inter;

import java.time.LocalDate;
import java.util.List;

import com.bookingSystem.model.Hotel;
import com.bookingSystem.model.Room;

/**
 * Interface for hotel Service 
 */
public interface IHotelService {

    /**
     * Searches for available rooms in a hotel based on the room type, check-in date, and check-out date.
     * @param hotel
     * @param roomType
     * @param checkIn
     * @param checkOut
     * @return List of available rooms
     */
    public List<Room> searchRooms(Hotel hotel, String roomType, LocalDate checkIn, LocalDate checkOut);

    /**
     * Finds hotels by city and availability based on the city, check-in date, and check-out date.
     * @param hotels
     * @param city
     * @param checkIn
     * @param checkOut
     * @return List of hotels with available rooms in the specified city
     */
    public List<Hotel> findHotelsByCityAndAvailability(List<Hotel> hotels, String city, LocalDate checkIn, LocalDate checkOut);

    /**
     * Finds all available hotels based on the list of hotels.
     * @param hotel
     * @return
     */
    public List<Hotel> findAllAvailbleHotels(List<Hotel> hotel);
}