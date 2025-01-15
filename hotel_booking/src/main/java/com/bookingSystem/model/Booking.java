package com.bookingSystem.model;

import java.time.LocalDate;

public class Booking {
    private final String bookingId;
    private final User user;
    private final Room room;
    private final Hotel hotel;
    private final LocalDate checkIn;
    private final LocalDate checkOut;

    public Booking(String bookingId, User user, Room room, Hotel hotel, LocalDate checkIn, LocalDate checkOut) {
        this.bookingId = bookingId;
        this.user = user;
        this.room = room;
        this.hotel = hotel;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}
