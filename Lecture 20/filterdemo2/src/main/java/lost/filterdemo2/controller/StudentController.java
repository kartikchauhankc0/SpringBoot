package lost.filterdemo2.controller;


import lost.filterdemo2.Dto.StudentDto;
import lost.filterdemo2.service.studentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/student")
public class StudentController {

    studentService studentService;
    public StudentController (studentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentDto studentDto){

        studentService.createStudent(studentDto);
        return ResponseEntity.ok("done");
    }


}
