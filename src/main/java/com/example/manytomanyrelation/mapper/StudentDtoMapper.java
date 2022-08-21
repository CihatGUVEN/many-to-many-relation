package com.example.manytomanyrelation.mapper;

import com.example.manytomanyrelation.dto.StudentDto;
import com.example.manytomanyrelation.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentDtoMapper extends BaseMapper<StudentDto, Student>{
}
