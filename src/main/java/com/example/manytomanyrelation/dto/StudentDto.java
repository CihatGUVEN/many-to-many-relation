package com.example.manytomanyrelation.dto;

import com.example.manytomanyrelation.entity.Parent;
import com.example.manytomanyrelation.entity.Phone;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long idNo;
    Set<Parent> parents;
}
