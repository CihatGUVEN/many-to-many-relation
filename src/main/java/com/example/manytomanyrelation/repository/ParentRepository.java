package com.example.manytomanyrelation.repository;

import com.example.manytomanyrelation.entity.Parent;
import com.example.manytomanyrelation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent, Long> {

    List<Parent> findAllByPhone_NumberIn(List<String> phoneNumbers);

    boolean existsParentByPhone_Number(String phoneNumber);
}
