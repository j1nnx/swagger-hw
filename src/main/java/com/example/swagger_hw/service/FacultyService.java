package com.example.swagger_hw.service;

import com.example.swagger_hw.model.Faculty;
import com.example.swagger_hw.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty>  faculties = new HashMap<>();
    private long lastId;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++lastId);
        faculties.put(lastId, faculty);
        return faculty;
    }

    public Faculty getFaculty(Long id){
        return faculties.get(id);
    }

    public Map<Long, Faculty> getFacultys() {
        return faculties;
    }

    public Faculty updateFaculty(Faculty faculty){
        if (faculties.containsKey(faculty.getId())){
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty(Long id){
        return faculties.remove(id);
    }
}
