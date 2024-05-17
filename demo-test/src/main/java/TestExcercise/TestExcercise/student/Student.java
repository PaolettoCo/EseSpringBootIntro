package TestExcercise.TestExcercise.student;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private boolean isWorking;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean working) {
        this.isWorking = working;
    }


    public static final class StudentBuilder {
        private Long id;
        private String name;
        private String surname;
        private boolean isWorking;

        private StudentBuilder() {
        }

        public static StudentBuilder aStudent() {
            return new StudentBuilder();
        }

        public StudentBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentBuilder withIsWorking(boolean isWorking) {
            this.isWorking = isWorking;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setIsWorking(isWorking);
            student.id = this.id;
            return student;
        }
    }
}
