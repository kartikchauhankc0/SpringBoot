package in.coderarmy.hibernateDemo.service;

import in.coderarmy.hibernateDemo.model.Student;
import in.coderarmy.hibernateDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

//    public List<Student> getAllStudents() {
//        return studentRepository.getAllStudent();
//    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(Student studentReq,Long id) {
        Student student1=studentRepository.findById(id);
        student1.setName(studentReq.getName());
        student1.setEmail(studentReq.getEmail());
        student1.setAge(studentReq.getAge());
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.remove(id);
    }
}