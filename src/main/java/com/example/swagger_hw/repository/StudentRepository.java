package com.example.swagger_hw.repository;

import com.example.swagger_hw.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAgeBetween(int minAge, int maxAge);
}
