package in.coderarmy.hibernateDemo.service;

import in.coderarmy.hibernateDemo.model.Student;
import in.coderarmy.hibernateDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }

//    public List<Student> getAllStudents() {
//        return studentRepository.getAllStudent();
//    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student, student.getId());
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }
}