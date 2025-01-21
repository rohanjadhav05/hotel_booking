package com.bookingSystem.model;

import java.time.LocalDate;

/**
 * HotelBooking class which extends abstract class Booking
 */
public class HotelBooking extends Booking{
    private Hotel hotel;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;

    /**
     * Constructor
     * @param user
     * @param hotel
     * @param room
     * @param checkIn
     * @param checkOut
     * @param bookingAmount
     */
    public HotelBooking(User user, Hotel hotel, Room room, LocalDate checkIn, LocalDate checkOut, double bookingAmount){
        super(user, bookingAmount);
        this.hotel = hotel;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    /**
     * getter for Hotel object
     * @return hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * getter for Room object
     * @return room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Get the checkIn date
     * @return checkIn
     */
    public LocalDate getCheckIn() {
        return checkIn;
    }

    /**
     * Get the checkOut date
     * @return checkOut
     */
    public LocalDate getCheckOut() {
        return checkOut;
    }

    /**
     * Setter for hotel
     * @param hotel
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Setter for the Room object
     * @param room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Setter the CheckIn Date
     * @param checkIn
     */
    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * Setter the Checkout Date
     * @param checkOut
     */
    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
}
