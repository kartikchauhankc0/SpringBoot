package com.example.AopProxy.service;

import com.example.AopProxy.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


        public Student createStudent(Student student){

            System.out.println("Student saved");

            throw new RuntimeException("some error exception");
            //return student;
        }
}
