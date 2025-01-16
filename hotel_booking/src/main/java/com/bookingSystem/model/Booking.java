package com.bookingSystem.model;

import java.time.LocalDate;

/**
 * The Booking class represents a booking with a booking ID, user, room, hotel, check-in date, and check-out date.
 */
public class Booking {
    private final String bookingId;
    private final User user;
    private final Room room;
    private final Hotel hotel;
    private final Double bookingAmount;
    private final LocalDate checkIn;
    private final LocalDate checkOut;

    /**
     * Constructor for Booking class
     * @param bookingId
     * @param user
     * @param room
     * @param hotel
     * @param bookingAmount
     * @param checkIn
     * @param checkOut
     */
    public Booking(String bookingId, User user, Room room, Hotel hotel, Double bookingAmount, LocalDate checkIn, LocalDate checkOut) {
        this.bookingId = bookingId;
        this.user = user;
        this.room = room;
        this.bookingAmount = bookingAmount;
        this.hotel = hotel;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    /**
     * Getters for booking ID
     * @return bookingId
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Getters for user
     * @return user object
     */
    public User getUser() {
        return user;
    }

    /**
     * Getters for room
     * @return room Object
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Getters for hotel
     * @return hotel object
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Getters for check-in date
     * @return checkIn
     */
    public LocalDate getCheckIn() {
        return checkIn;
    }

    /**
     * Getters for check-out date
     * @return checkOut
     */
    public LocalDate getCheckOut() {
        return checkOut;
    }

    /**
     * Getters for booking amount
     * @return bookingAmount
     */
    public Double getBookingAmount() {
        return bookingAmount;
    }
}
