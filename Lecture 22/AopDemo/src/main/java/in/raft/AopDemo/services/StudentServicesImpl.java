package in.raft.AopDemo.services;

import in.raft.AopDemo.dto.Student;
import in.raft.AopDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServicesImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentServicesImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public void  createStudent(Student student){
        studentRepository.save(student);


    }

}
