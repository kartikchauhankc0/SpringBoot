package in.raft.AopDemo.services;

import in.raft.AopDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LoggingDecorator implements StudentService{

    private StudentServicesImpl studentServicesimpl;

    public LoggingDecorator(StudentServicesImpl studentServicesimpl){
        this.studentServicesimpl=studentServicesimpl;
    }

    @Override
    public void createStudent(Student student) {

        //logging logic
        LoggingServiceUtil.logStart(
                "StudentService",
                "createStudent");

        studentServicesimpl.createStudent(student);

        LoggingServiceUtil.logEnd(
                "StudentService",
                "createStudent");
    }
}
