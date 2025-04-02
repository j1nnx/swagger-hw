package com.example.swagger_hw.service;

import com.example.swagger_hw.model.Faculty;
import com.example.swagger_hw.model.Student;
import com.example.swagger_hw.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacultyService{
    private FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(Long id){
        return facultyRepository.findById(id).orElse(null);
    }

    public List<Faculty> getFacultys() {
        return facultyRepository.findAll();
    }

    public Faculty updateFaculty(Faculty faculty){
        if (facultyRepository.existsById(faculty.getId())){
            return facultyRepository.save(faculty);
        }
        return null;
    }

    public Faculty deleteFaculty(Long id){
        if (facultyRepository.existsById(id)){
            Faculty faculty = facultyRepository.findById(id).orElse(null);
            facultyRepository.deleteById(id);
            return faculty;
        }
        return null;
    }
}
