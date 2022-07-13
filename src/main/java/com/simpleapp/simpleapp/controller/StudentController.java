package com.simpleapp.simpleapp.controller;

import com.simpleapp.simpleapp.dao.StudentRepository;
import com.simpleapp.simpleapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/api/students")
        public List<Student> getStudents(){
        return studentRepository.findAll();
        }
}
