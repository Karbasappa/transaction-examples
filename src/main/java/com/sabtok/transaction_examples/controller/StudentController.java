package com.sabtok.transaction_examples.controller;

import com.sabtok.transaction_examples.entity.Student;
import com.sabtok.transaction_examples.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @DeleteMapping()
    public String deleteStudent(@RequestBody Student student) {
         studentRepository.delete(student);
        return "Removed..";
    }
}
