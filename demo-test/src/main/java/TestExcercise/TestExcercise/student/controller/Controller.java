package TestExcercise.TestExcercise.student.controller;

import TestExcercise.TestExcercise.student.Student;
import TestExcercise.TestExcercise.student.dto.Mapper;
import TestExcercise.TestExcercise.student.dto.StudentDto;
import TestExcercise.TestExcercise.student.dto.StudentListDto;
import TestExcercise.TestExcercise.student.repo.Repository;
import TestExcercise.TestExcercise.student.service.Service;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class Controller {

    private final Repository repository;
    private final Service service;
    private final Mapper mapper;

    public Controller(Repository repository, Service service, Mapper mapper) {
        this.repository = repository;
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/save")
    public Student save(@RequestBody StudentDto studentDto){
        return repository.save(mapper.toStudent(studentDto));
    }

    @GetMapping
    public StudentListDto getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){

        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found"));
    }

    @PutMapping("/update")
    public Student update(@RequestBody Student student){
        return service.update(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestParam boolean isWorking){
        return service.updateIsWorking(id, isWorking);
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable Long id){
        Student student = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found"));
        repository.delete(student);
        return student;
    }
}
