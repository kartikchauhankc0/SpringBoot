package in.pixel.CustomAop.controller;


import in.pixel.CustomAop.dto.Student;
import in.pixel.CustomAop.service.StudentService;
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
