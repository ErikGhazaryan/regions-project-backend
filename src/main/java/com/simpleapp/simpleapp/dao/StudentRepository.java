package com.simpleapp.simpleapp.dao;


import com.simpleapp.simpleapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  StudentRepository extends JpaRepository<Student, Long> {
}
