package com.example.democrud.car;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Car {
    @Id
    private UUID id = UUID.randomUUID();
    private String model;
    private Type type;

    public UUID getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type{
        SUV,
        UTILITARIA
    }
}
