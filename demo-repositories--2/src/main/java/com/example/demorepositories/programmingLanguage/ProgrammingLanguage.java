package com.example.demorepositories.programmingLanguage;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(
            name = "name",
            nullable = false)
    private String name;

    @Column(name = "first_appearance ")
    private Integer firstAppearance ;

    @Column(
            name = "inventor ",
            nullable = false)
    private String inventor  ;

    public ProgrammingLanguage() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getFirstAppearance() {
        return firstAppearance;
    }

    public String getInventor() {
        return inventor;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstAppearance(Integer firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    @Override
    public String toString() {
        return "ProgrammingLanguage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstAppearance=" + firstAppearance +
                ", inventor='" + inventor + '\'' +
                '}';
    }
}
