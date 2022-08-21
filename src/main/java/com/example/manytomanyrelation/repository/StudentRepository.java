package com.example.manytomanyrelation.repository;

import com.example.manytomanyrelation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
