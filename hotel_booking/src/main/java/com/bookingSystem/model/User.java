package com.bookingSystem.model;

/**
 * User class represents a user with a name and phone number.
 */
public class User extends BaseEntity{
    private String name;
    private String number;

    /**
     * Constructor for User
     * @param name
     * @param number
     */
    public User(String name, String number) {
        super();
        this.name = name;
        this.number = number;
    }
    
    /**
     * Getters for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getters for number
     * @return number
     */
    public String getNumber() {
        return number;
    }
}
