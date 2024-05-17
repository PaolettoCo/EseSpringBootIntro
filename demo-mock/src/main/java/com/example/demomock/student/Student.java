package com.example.demomock.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Student {

    @Id
    private UUID id;

    @Column(
            name = "last_name",
            nullable = false)
    private String lastName;
    @Column(
            name = "first_name",
            nullable = false)
    private String firstNAme;
    @Column(
            name = "email",
            unique = true,
            nullable = false)
    private String email;

}
