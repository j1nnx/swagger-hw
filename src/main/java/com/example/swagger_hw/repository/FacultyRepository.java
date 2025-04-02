package com.example.swagger_hw.repository;

import com.example.swagger_hw.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
