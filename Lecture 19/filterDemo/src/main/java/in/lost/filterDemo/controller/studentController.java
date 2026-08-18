package in.lost.filterDemo.controller;


import in.lost.filterDemo.service.studentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/student")
public class studentController {

    studentService studentService;
    public studentController (studentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(){

        studentService.createStudent();
        return ResponseEntity.ok("done");
    }


}
