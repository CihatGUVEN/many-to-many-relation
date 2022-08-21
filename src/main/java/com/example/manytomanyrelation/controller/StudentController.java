package com.example.manytomanyrelation.controller;

import com.example.manytomanyrelation.dto.StudentDto;
import com.example.manytomanyrelation.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping()
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }
}
