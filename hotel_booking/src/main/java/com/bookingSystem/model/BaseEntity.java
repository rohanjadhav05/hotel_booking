package com.bookingSystem.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base class which will be exetend to generate the Id
 */
public abstract class BaseEntity{
    protected final String id;
    private static int userCounter = 0;
    private LocalDateTime createdAt;
    
    /**
     * Parameterless constructor
     */
    protected BaseEntity() {
        if(this instanceof Booking){
            this.id = UUID.randomUUID().toString();
        }else{
            userCounter++;
            this.id = String.valueOf(userCounter);
        }
        createdAt = LocalDateTime.now();
        
    }
    
    /**
     * get the id
     * @return
     */
    public String getId() {
        return id;
    }
    
    /**
     * get the creational time of ID
     * @return
     */
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
}