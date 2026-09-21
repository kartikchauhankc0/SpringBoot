package org.example;


import org.example.model.Student;
import org.example.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static void main() {

        StudentRepository studentRepository=new StudentRepository();

        studentRepository.createUser(new Student("kartik22","kartik11@gmail.com",23));

        //studentRepository.updateUser();

        //studentRepository.deleteUser();

        //studentRepository.getUserById();




    }

}
