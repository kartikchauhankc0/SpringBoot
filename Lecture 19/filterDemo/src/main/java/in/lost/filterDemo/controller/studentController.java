package in.lost.filterDemo.controller;


import in.lost.filterDemo.dto.StudentDto;
import in.lost.filterDemo.service.studentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<String> createStudent(@RequestBody StudentDto studentDto){

        studentService.createStudent(studentDto);
        return ResponseEntity.ok("done");
    }


}
