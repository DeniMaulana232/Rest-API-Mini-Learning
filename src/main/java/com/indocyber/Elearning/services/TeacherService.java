package com.indocyber.Elearning.services;

import com.indocyber.Elearning.dtos.Teacher.TeacherHeaderDto;
import com.indocyber.Elearning.dtos.Teacher.TeacherInsertDto;
import com.indocyber.Elearning.dtos.Teacher.TeacherUpdateDto;
import com.indocyber.Elearning.models.Teacher;
import com.indocyber.Elearning.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherHeaderDto> findAllTeacher(){
        return TeacherHeaderDto.toList(teacherRepository.findAll());
    }

    public List<TeacherHeaderDto> findTeacherByName(String name){
        return TeacherHeaderDto.toList(teacherRepository.findTeacherByName(name));
    }

    public TeacherHeaderDto insertDataTeacher(TeacherInsertDto teacherDto){
        Teacher teacher = teacherDto.convert();
        teacherRepository.save(teacher);
        return TeacherHeaderDto.set(teacher);
    }

    public TeacherHeaderDto updateDataTeacher(Integer id, TeacherUpdateDto teacher){
            Teacher oldTeacher = teacherRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("id tidak ditemukan"));

            oldTeacher.setNuptk(teacher.getNuptk() == null ? oldTeacher.getNuptk() : teacher.getNuptk());
            oldTeacher.setFirstName(teacher.getFirstName() == null ? oldTeacher.getFirstName() : teacher.getFirstName());
            oldTeacher.setLastName(teacher.getLastName() == null ? oldTeacher.getLastName() : teacher.getLastName() );
            oldTeacher.setEmail(teacher.getEmail() == null ? oldTeacher.getEmail() : teacher.getEmail());
            oldTeacher.setAddress(teacher.getAddress() == null ? oldTeacher.getAddress() : teacher.getAddress());
            oldTeacher.setPhone(teacher.getPhone() == null ? oldTeacher.getPhone() : teacher.getPhone());

            teacherRepository.save(oldTeacher);
            return TeacherHeaderDto.set(oldTeacher);
    }

        public List<TeacherHeaderDto> deleteTeacherById(Integer id){
            teacherRepository.deleteById(id);
            return TeacherHeaderDto.toList(teacherRepository.findAll());
        }


}
