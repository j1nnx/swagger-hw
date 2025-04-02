package com.example.swagger_hw.controller;

import com.example.swagger_hw.model.Faculty;
import com.example.swagger_hw.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable Long id){
        return facultyService.getFaculty(id);
    }

    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty){
        return facultyService.updateFaculty(faculty);
    }

    @DeleteMapping("/{id}")
    public Faculty deleteFaculty(@PathVariable Long id){
        return facultyService.deleteFaculty(id);
    }

    @GetMapping("/filter")
    public List<Faculty> filterFacultiesByColor(@RequestParam String color) {
        return facultyService.getFacultys()
                .stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .toList();
    }
}
