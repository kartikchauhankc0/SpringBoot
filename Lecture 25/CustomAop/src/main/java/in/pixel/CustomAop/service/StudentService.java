package in.pixel.CustomAop.service;


import in.pixel.CustomAop.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent(Student student){

        System.out.println("Student saved");

        //throw new RuntimeException("some error exception");
        return student;
    }

    public String getStudent(String s) {
        System.out.println(s);
        return s;
    }
}
