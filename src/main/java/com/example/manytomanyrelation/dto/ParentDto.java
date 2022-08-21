package com.example.manytomanyrelation.dto;

import com.example.manytomanyrelation.entity.Parent;
import com.example.manytomanyrelation.entity.Phone;
import com.example.manytomanyrelation.entity.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
public class ParentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Phone phone;
    Set<Student> students;
}
