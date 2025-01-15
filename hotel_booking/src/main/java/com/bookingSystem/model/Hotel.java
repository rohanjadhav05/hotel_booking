package com.bookingSystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hotel with a name, location, and a list of rooms.
 */
public class Hotel {
    private String name;
    private String location;
    private List<Room> rooms;

    /**
     * Constructs a new Hotel with the specified name and location.
     *
     * @param name     the name of the hotel
     * @param location the location of the hotel
     */
    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
        this.rooms = new ArrayList<>();
    }

    /**
     * @return Returns the name of the hotel.
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return Returns the location of the hotel.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Adds a room to the hotel.
     * @param room 
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * 
     * @return Returns the list of rooms in the hotel.
     */
    public List<Room> getRooms() {
        return rooms;
    }
}
