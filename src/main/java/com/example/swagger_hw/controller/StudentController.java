package com.example.swagger_hw.controller;

import com.example.swagger_hw.model.Student;
import com.example.swagger_hw.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.studentCreate(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/filter")
    public List<Student> filterStudentsByAge(@RequestParam int age) {
        return studentService.getStudents()
                .values()
                .stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }

}
