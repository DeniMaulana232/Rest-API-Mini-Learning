package com.indocyber.Elearning.services;

import com.indocyber.Elearning.dtos.Student.StudentHeaderDto;
import com.indocyber.Elearning.dtos.Student.StudentInsertDto;
import com.indocyber.Elearning.dtos.Student.StudentUpdateDto;
import com.indocyber.Elearning.dtos.Subject.SubjectHeaderDto;
import com.indocyber.Elearning.models.Student;
import com.indocyber.Elearning.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentHeaderDto> findAllStudent() {
        return StudentHeaderDto.toList(studentRepository.findAll());
    }

    public StudentHeaderDto findStudentById(Integer id) {
        return StudentHeaderDto.set(studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found")));
    }

    public StudentInsertDto insertStudent(StudentInsertDto insertDto) {
        Student student = new Student(insertDto.getRoomClass(),
                insertDto.getFirstName(),
                insertDto.getLastName(),
                insertDto.getNik(),
                insertDto.getAddress(),
                insertDto.getYearsId()
        );
        studentRepository.save(student);
        return StudentInsertDto.convert(student);
    }

    public StudentUpdateDto updateStudent(Integer id, StudentUpdateDto updateDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setFirstName(updateDto.getFirstName() == null ? student.getFirstName() : updateDto.getFirstName());
        student.setLastName(updateDto.getLastName() == null ? student.getLastName() : updateDto.getLastName());
        student.setNik(updateDto.getNik() == null ? student.getNik() : updateDto.getNik());
        student.setAddress(updateDto.getAddress() == null ? student.getAddress() : updateDto.getAddress());
        student.setRoomClass(updateDto.getRoom() == null ? student.getRoomClass().getId(): updateDto.getRoom());
        studentRepository.save(student);
        return StudentUpdateDto.convert(student);
    }


    public List<StudentHeaderDto> deleteTeacherById(Integer id){
        studentRepository.deleteById(id);
        return StudentHeaderDto.toList(studentRepository.findAll());
    }
}
