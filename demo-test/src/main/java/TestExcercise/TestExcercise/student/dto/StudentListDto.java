package TestExcercise.TestExcercise.student.dto;


import TestExcercise.TestExcercise.student.Student;

import java.util.List;

public class StudentListDto {
    List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public static final class StudentListDtoBuilder {
        private List<Student> students;

        private StudentListDtoBuilder() {
        }

        public static StudentListDtoBuilder aStudentListDto() {
            return new StudentListDtoBuilder();
        }

        public StudentListDtoBuilder withStudents(List<Student> students) {
            this.students = students;
            return this;
        }

        public StudentListDto build() {
            StudentListDto studentListDto = new StudentListDto();
            studentListDto.setStudents(students);
            return studentListDto;
        }
    }
}
