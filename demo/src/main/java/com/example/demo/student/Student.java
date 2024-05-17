package com.example.demo.student;

import com.example.demo.classP.Classes;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Integer idStudent;
    @Column(
            name = "last_name",
            nullable = false)
    private String lastName;
    @Column(
            name = "first_name",
            nullable = false)
    private String firstName;

    @Column(
            name = "email",
            unique = true)
    private String email;

    @ManyToMany(
            mappedBy = "students",
            fetch = FetchType.LAZY
    )
    private Set<Classes> classes;

    public Student() {
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
