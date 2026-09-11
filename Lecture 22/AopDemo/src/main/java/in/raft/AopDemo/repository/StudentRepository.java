package in.raft.AopDemo.repository;

import in.raft.AopDemo.dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public void save(Student student) {
        System.out.println("Student saved");

    }
}
