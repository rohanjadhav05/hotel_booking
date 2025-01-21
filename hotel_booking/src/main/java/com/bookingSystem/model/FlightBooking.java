package com.bookingSystem.model;

import java.time.LocalDate;

/**
 * FlightBooking class which extends abstract class Booking
 */
public class FlightBooking extends Booking{
    private String origin;
    private String destination;
    private LocalDate departureDate;

    /**
     * Constructor for FlightBooking
     * @param user
     * @param origin
     * @param destination
     * @param departureDate
     * @param bookingAmount
     */
    public FlightBooking(User user, String origin, String destination, LocalDate departureDate, double bookingAmount){
        super(user, bookingAmount);
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
    
}
