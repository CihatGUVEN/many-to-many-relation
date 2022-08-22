package com.example.manytomanyrelation.implementation;

import com.example.manytomanyrelation.dto.ParentDto;
import com.example.manytomanyrelation.dto.StudentDto;
import com.example.manytomanyrelation.entity.Parent;
import com.example.manytomanyrelation.entity.Student;
import com.example.manytomanyrelation.mapper.ParentDtoMapper;
import com.example.manytomanyrelation.mapper.StudentDtoMapper;
import com.example.manytomanyrelation.repository.StudentRepository;
import com.example.manytomanyrelation.service.ParentService;
import com.example.manytomanyrelation.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ParentService parentService;
    private final ParentDtoMapper parentDtoMapper;
    private final StudentDtoMapper studentDtoMapper;

    @Override
    public StudentDto addStudentWithParent(StudentDto studentDto) {
        Set<ParentDto> parentSavedDto = saveOrGetParents(parentDtoMapper.entitySetToDtoSet(studentDto.getParents()));
        studentDto.setParents(new HashSet<>());
        studentDto = studentDtoMapper.entityToDto(studentRepository.save(studentDtoMapper.dtoToEntity(studentDto)));

        Student student = studentDtoMapper.dtoToEntity(studentDto);
        parentSavedDto.forEach(parentDto ->{
                    Set<Student> studentSetToUpdate = parentDto.getStudents();
                    studentSetToUpdate.add(student);
                    parentDto.setStudents(studentSetToUpdate);
                    parentService.updateParent(parentDto.getId(), parentDto);
                });
        studentDto.setParents(parentDtoMapper.dtoSetToEntitySet(parentSavedDto));
        return studentDto;
    }


    @Override
    public StudentDto getById(Long id) {
        return studentDtoMapper.entityToDto(studentRepository.findById(id).orElseThrow(RuntimeException::new));
    }


    public Set<ParentDto> saveOrGetParents(Set<ParentDto> parentDtoSet){
        Set<ParentDto> updatedDto = new HashSet<>();
        parentDtoSet.forEach(parentDto -> {
            if (!parentService.existsParentByPhone_Number(parentDto.getPhone().getNumber())) {
                updatedDto.add(parentService.addParent(parentDto));
            } else{
                parentDto = parentDtoMapper.entityToDto(parentService.findByPhone_Number(parentDto.getPhone().getNumber()));
                updatedDto.add(parentDto);
            }
        });
        return updatedDto;
    }

}
