package com.example.manytomanyrelation.service;

import com.example.manytomanyrelation.dto.ParentDto;
import com.example.manytomanyrelation.entity.Parent;

import java.util.List;

public interface ParentService {

    ParentDto addParent(ParentDto parentDto);

    List<ParentDto> findAllByPhoneNumbers(List<ParentDto> parentDtoList);

    boolean existsParentByPhone_Number(String phoneNumber);

    Parent findById(Long id);

    ParentDto updateParent(Long id, ParentDto parentDto);
}
