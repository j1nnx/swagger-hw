package com.example.swagger_hw.repository;

import com.example.swagger_hw.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAgeBetween(int minAge, int maxAge);

    @Query("SELECT COUNT(s) FROM Student s")
    Long getTotalStudentsCount();

    @Query("SELECT AVG(s.age) FROM Student s")
    Double getAverageAge();

    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> findLastFiveStudents();
}
