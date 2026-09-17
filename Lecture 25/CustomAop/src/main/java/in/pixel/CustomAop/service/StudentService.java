package in.pixel.CustomAop.service;


import in.pixel.CustomAop.annotation.TrackExecutionTime;
import in.pixel.CustomAop.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(
            warnAfter = 500,
            operation = "creating a new student"
    )
    public Student createStudent(Student student){

        System.out.println("Student saved");

        //throw new RuntimeException("some error exception");
        return student;
    }

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "get all data"
    )
    public String getStudent(String s) {
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){}
        System.out.println(s);
        return s;
    }
}
