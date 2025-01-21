package com.bookingSystem.util;

/**
 * Exception Handeler Helper class to print the exception
 * Singleton Design Pattern in used here
 */
public class ExceptionUtil {
    
    private static ExceptionUtil instance;

    /*
     * private Constructor so that the instance will be created within the class itself
     */
    private ExceptionUtil(){};

    /*
     * static method which checks if instance has been created 
     * if it not created will create one and return the new instance
     */
    public static ExceptionUtil getInstance(){
        if(instance == null){
            instance = new ExceptionUtil();
        }
        return instance;
    }
    
    /**
     * will araise when user enter's invalid mobile number
     */
    public void invalidMobileNumber(){
        printBefore();
        System.out.println("Invalid Mobile Number !!! Mobile number should be of 10 digits");
        printAfter();
    }

    /**
     * Will araise when mobile number < 10 or number > 10
     */
    public void mobileNumberDigits(){
        printBefore();
        System.out.println("Invalid Mobile Number !!! Mobile number should contain only digits");
        printAfter();
    }

    /**
     * Will araise when booking with name is not found
     * @param name
     */
    public void noBookingFound(String name){
        printBefore();
        System.out.println("No bookings found for " + name);
        printAfter();
    }

    /**
     * Will araise when the choice entered by user is invalid
     */
    public void invalidChoice(){
        printBefore();
        System.out.println("Invalid choice. Please try again.");
        printAfter();
    }

    /**
     * Will araise when date is not in correct format
     */
    public void invalideDateFormat(){
        printBefore();
        System.out.println("Invalid Date Format");
        printAfter();
    }

    /**
     * Will araise when there is no hotel in specified city
     */
    public void noHotelFound(){
        printBefore();
        System.out.println("No hotels found in the specified city or date range.");
        printAfter();
    }

    /**
     * Will araise when checkIn is after the checkout date
     */
    public void checkInDateExecpetion(){
        printBefore();
        System.out.println("Check-in date must be before the check-out date.");
        printAfter();
    }

    /**
     * Will print before the exception
     */
    public static void printBefore(){
        System.out.println("------------------------------------");
        System.out.println();
    }

    /**
     * Will print after the exception
     */
    public static void printAfter(){
        System.out.println();
        System.out.println("------------------------------------");
    }
}
