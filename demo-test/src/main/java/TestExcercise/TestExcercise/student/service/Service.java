package TestExcercise.TestExcercise.student.service;
import TestExcercise.TestExcercise.student.Student;
import TestExcercise.TestExcercise.student.dto.Mapper;
import TestExcercise.TestExcercise.student.dto.StudentListDto;
import TestExcercise.TestExcercise.student.repo.Repository;

@org.springframework.stereotype.Service
public class Service {
    private final Mapper mapper;
    private final Repository repository;

    public Service(Mapper mapper, Repository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public StudentListDto getAll() {
        return mapper.toStudentListDto(repository.findAll());
    }

    public Student update(Student student){
        if(student.getId() == null){
            throw new RuntimeException("non-existent Student");
        }
        return repository.save(student);
    }

    public Student updateIsWorking(Long id, boolean isWorking) {
        Student student = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
        student.setIsWorking(isWorking);
        return student;
    }
}
