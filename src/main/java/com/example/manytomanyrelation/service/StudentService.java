package com.example.manytomanyrelation.service;

import com.example.manytomanyrelation.dto.StudentDto;

public interface StudentService {

    public StudentDto addStudentWithParent(StudentDto studentDto);

    StudentDto getById(Long id);

}
