package com.example.AopProxy.controller;


import com.example.AopProxy.dto.Student;
import com.example.AopProxy.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController (StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        Student s = studentService.createStudent(student);

        return ResponseEntity.ok(s);

    }
    @GetMapping
    public ResponseEntity<String> getStudent(){
        String s="all student data";
        return ResponseEntity.ok(studentService.getStudent(s));
    }

}

