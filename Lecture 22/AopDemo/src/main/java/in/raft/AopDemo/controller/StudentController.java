package in.raft.AopDemo.controller;

import in.raft.AopDemo.dto.Student;
import in.raft.AopDemo.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentservice){
        this.studentService = studentservice;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(Student student){
            studentService.createStudent(student);

            return ResponseEntity.ok("Done");
    }
}
