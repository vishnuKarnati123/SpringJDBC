package com.vishnu.springJdbc.service;

import com.vishnu.springJdbc.model.Student;
import com.vishnu.springJdbc.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public StudentService() {
        System.out.println("StudentService object created");
    }

    public void addStudent(Student s) {
        studentRepo.save(s);
        System.out.println("Student added");

    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }
}
