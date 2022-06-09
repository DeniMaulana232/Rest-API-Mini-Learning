package com.indocyber.Elearning.controllers;

import com.indocyber.Elearning.dtos.Student.StudentHeaderDto;
import com.indocyber.Elearning.dtos.Student.StudentInsertDto;
import com.indocyber.Elearning.dtos.Student.StudentUpdateDto;
import com.indocyber.Elearning.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("index")
    public List<StudentHeaderDto> findALlStudent(){
        return service.findAllStudent();
    }

    @RequestMapping("index/{id}")
    public StudentHeaderDto findStudentById(Integer id){
        return service.findStudentById(id);
    }

    @RequestMapping("insert")
    public StudentInsertDto insertStudent(@RequestBody StudentInsertDto insertDto){
        return service.insertStudent(insertDto);
    }

    @RequestMapping("update/{id}")
    public StudentUpdateDto updateStudent(@PathVariable Integer id, @RequestBody StudentUpdateDto updateDto){
        return service.updateStudent(id, updateDto);
    }

    @DeleteMapping("delete/{id}")
    public List<StudentHeaderDto> deleteStudent(@PathVariable Integer id){
        return service.deleteTeacherById(id);
    }
}
