package com.example.swagger_hw.service;

import com.example.swagger_hw.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private long lastId = 0;

    public Student studentCreate(Student student){
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Student getStudent(Long id){
        return students.get(id);
    }

    public Map<Long, Student> getStudents() {
        return students;
    }

    public Student updateStudent(Student student){
        if (students.containsKey(student.getId())){
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(Long id){
        return students.remove(id);
    }
}
