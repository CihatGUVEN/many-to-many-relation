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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ParentService parentService;
    private final ParentDtoMapper parentDtoMapper;
    private final StudentDtoMapper studentDtoMapper;

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Set<ParentDto> parentDtoSet = parentDtoMapper.entitySetToDtoSet(new HashSet<>(studentDto.getParents()));
//        saveOrUpdateParents(parentDtoSet);
        Student saveStudent = studentRepository.save(studentDtoMapper.dtoToEntity(studentDto));
        Set<Student> studentToUpdate = new HashSet<>();
        studentToUpdate.add(saveStudent);
        Set<ParentDto> parentDtoSetToUpdate = parentDtoMapper.entitySetToDtoSet(new HashSet<>(saveStudent.getParents()));
        parentDtoSetToUpdate.forEach(parent -> parent.setStudents(studentToUpdate));
        parentDtoSetToUpdate.forEach(parent -> parentService.updateParent(parent.getId(), parent));
        return studentDtoMapper.entityToDto(saveStudent);
    }

//    public Student mapDtoToEntity(StudentDto studentDto){
//        Student student = new Student();
//        student.setFirstName(studentDto.getFirstName());
//        student.setLastName(studentDto.getLastName());
//        student.setIdNo(studentDto.getIdNo());
//        student.setParents(studentDto.getParents());
//        return student;
//    }
//
//    public StudentDto mapEntityToDto(Student student){
//        StudentDto studentDto = new StudentDto();
//        studentDto.setFirstName(student.getFirstName());
//        studentDto.setLastName(student.getLastName());
//        studentDto.setIdNo(student.getIdNo());
//        studentDto.setParents(student.getParents());
//        return studentDto;
//    }

    public Set<ParentDto> saveOrUpdateParents(Set<ParentDto> parentDtoSet){

        parentDtoSet.forEach(parent -> {
            if (!parentService.existsParentByPhone_Number(parent.getPhone().getNumber())) {
                //todo yoksa create
                parentService.addParent(parent);
            }
            //TODO varsa update
        });

        return parentDtoSet;


//        List<ParentDto> parentDtoFoundList = parentService.findAllByPhoneNumbers(parentDtoList);
//
//        List<Parent> parentFoundList = parentDtoMapper.dtoListToEntityList(parentDtoFoundList);
//
//        Set<Parent> parentFoundSet = new HashSet<>(parentFoundList);
//
//        Set<Parent> parentNotFoundSet = parentSetDto;
//
//        for(Parent parent : parentNotFoundSet){
//            for(Parent parent1 : parentFoundSet){
//                if(parent.getPhone().getNumber() == parent1.getPhone().getNumber())
//                    parentNotFoundSet.remove(parent);
//            }
//        }
//
//        parentNotFoundSet.forEach(parent -> parentService.addParent(parentDtoMapper.entityToDto(parent)));
//
//        return parentSetDto;
    }

}
