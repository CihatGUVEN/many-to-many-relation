package com.example.manytomanyrelation.implementation;

import com.example.manytomanyrelation.dto.ParentDto;
import com.example.manytomanyrelation.dto.StudentDto;
import com.example.manytomanyrelation.entity.Parent;
import com.example.manytomanyrelation.entity.Student;
import com.example.manytomanyrelation.mapper.ParentDtoMapper;
import com.example.manytomanyrelation.repository.ParentRepository;
import com.example.manytomanyrelation.repository.StudentRepository;
import com.example.manytomanyrelation.service.ParentService;
import com.example.manytomanyrelation.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;
    private final ParentDtoMapper parentDtoMapper;

    @Override
    public ParentDto addParent(ParentDto parentDto) {
        Parent parent = parentDtoMapper.dtoToEntity(parentDto);
        Parent saveParent = parentRepository.save(parent);
        ParentDto savedParentDto = parentDtoMapper.entityToDto(saveParent);
        return savedParentDto;
    }

    @Override
    public List<ParentDto> findAllByPhoneNumbers(List<ParentDto> parentDtoList) {
        List<Parent> parentList = parentDtoMapper.dtoListToEntityList(parentDtoList);
        List<String> phoneNumberList = parentList.stream().map(parent->parent.getPhone().getNumber()).collect(Collectors.toList());

        List<Parent> parentFoundList= parentRepository.findAllByPhone_NumberIn(phoneNumberList);
        List<ParentDto> parentFoundDtoList = parentDtoMapper.entityListToDtoList(parentFoundList);
        return parentFoundDtoList;
    }

    @Override
    public boolean existsParentByPhone_Number(String phoneNumber) {
        return false;
    }

    @Override
    public Parent findById(Long id) {
        return parentRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public ParentDto updateParent(Long id, ParentDto parentDto) {
        Parent parent = findById(id);
        parent.setPhone(parentDto.getPhone());
        parent.setFirstName(parentDto.getFirstName());
        parent.setLastName(parentDto.getLastName());
        parent.setStudents(parentDto.getStudents());
        return parentDtoMapper.entityToDto(parentRepository.save(parent));

    }
}
