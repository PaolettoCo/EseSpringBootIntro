package com.example.demo.classP;

import com.example.demo.student.Student;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class")
    private Integer idClass;
    @Column(
            name = "title",
            nullable = false)
    private String title;
    @Column(
            name = "description",
            nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(name = "Class_Student")
    private Set<Student> students;

    public Classes() {
    }

    public Integer getIdClass() {
        return idClass;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ClassC{" +
                "idClass=" + idClass +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
