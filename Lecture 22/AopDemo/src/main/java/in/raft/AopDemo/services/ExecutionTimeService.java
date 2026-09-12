package in.raft.AopDemo.services;

import in.raft.AopDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeService implements StudentService{

    private LoggingDecorator loggingDecorator;

    public ExecutionTimeService(LoggingDecorator loggingDecorator){
        this.loggingDecorator=loggingDecorator;
    }

    @Override
    public void createStudent(Student student) {

        long StartTime=System.currentTimeMillis();

        loggingDecorator.createStudent(student);

        long endTime=System.currentTimeMillis();

        long Duration = endTime-StartTime;

        System.out.println("Duration : "+ Duration);

    }
}
