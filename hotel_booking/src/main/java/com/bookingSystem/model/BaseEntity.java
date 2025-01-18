package com.bookingSystem.model;

import java.util.UUID;

public abstract class BaseEntity{
    protected final String id;
    
    protected BaseEntity() {
        this.id = UUID.randomUUID().toString();
    }
    
    public String getId() {
        return id;
    }
}