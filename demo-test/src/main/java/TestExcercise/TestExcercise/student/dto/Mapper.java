package TestExcercise.TestExcercise.student.dto;



import TestExcercise.TestExcercise.student.Student;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Mapper {

    public StudentListDto toStudentListDto(List<Student> list){
        return StudentListDto.StudentListDtoBuilder.aStudentListDto()
                .withStudents(list)
                .build();
    }

    public Student toStudent(StudentDto studentDto){
        return Student.StudentBuilder.aStudent()
                .withIsWorking(studentDto.isWorking())
                .withName(studentDto.getName())
                .withSurname(studentDto.getSurname())
                .build();
    }

}
