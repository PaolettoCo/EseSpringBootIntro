package TestExcercise.TestExcercise.student.dto;

import java.util.Objects;

public class StudentDto {
    private String name;
    private String surname;
    private boolean isWorking;

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

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return isWorking == that.isWorking && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, isWorking);
    }

    public static final class StudentDtoBuilder {
        private String name;
        private String surname;
        private boolean isWorking;

        private StudentDtoBuilder() {
        }

        public static StudentDtoBuilder aStudentDto() {
            return new StudentDtoBuilder();
        }

        public StudentDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public StudentDtoBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentDtoBuilder withIsWorking(boolean isWorking) {
            this.isWorking = isWorking;
            return this;
        }

        public StudentDto build() {
            StudentDto studentDto = new StudentDto();
            studentDto.setName(name);
            studentDto.setSurname(surname);
            studentDto.isWorking = this.isWorking;
            return studentDto;
        }
    }
}
