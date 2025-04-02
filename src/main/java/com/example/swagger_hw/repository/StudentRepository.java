package com.example.swagger_hw.repository;

import com.example.swagger_hw.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
