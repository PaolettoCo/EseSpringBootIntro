package TestExcercise.TestExcercise.student.repo;


import TestExcercise.TestExcercise.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Student, Long> {
}
