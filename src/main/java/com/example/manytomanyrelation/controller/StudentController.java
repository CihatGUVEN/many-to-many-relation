package com.example.manytomanyrelation.controller;

import com.example.manytomanyrelation.dto.StudentDto;
import com.example.manytomanyrelation.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping()
    public StudentDto createStudentWithPartents(@RequestBody StudentDto studentDto) {
        return studentService.addStudentWithParent(studentDto);
    }

}
