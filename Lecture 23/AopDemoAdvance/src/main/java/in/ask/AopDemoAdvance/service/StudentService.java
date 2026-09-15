package in.ask.AopDemoAdvance.service;


import in.ask.AopDemoAdvance.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent(Student student){

        System.out.println("Student saved");

        throw new RuntimeException("some error exception");
      //return student;
    }
}
