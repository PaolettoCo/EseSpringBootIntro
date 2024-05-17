package com.example.demorepositories.car;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String model;

    @Column(
            name = "serial_number",
            nullable = false)
    private String serialNumber;

    @Column(
            name = "current_price",
            nullable = false)
    private Double currentPrice;

    public Car() {
    }

    public UUID getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
