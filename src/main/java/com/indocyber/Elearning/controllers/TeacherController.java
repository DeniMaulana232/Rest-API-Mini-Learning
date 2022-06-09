package com.indocyber.Elearning.controllers;

import com.indocyber.Elearning.dtos.Teacher.TeacherHeaderDto;
import com.indocyber.Elearning.dtos.Teacher.TeacherInsertDto;
import com.indocyber.Elearning.dtos.Teacher.TeacherUpdateDto;
import com.indocyber.Elearning.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    private TeacherService service;

    @Autowired
    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping("index")
    public List<TeacherHeaderDto> findAllTeacher(){
        return service.findAllTeacher();
    }

    @GetMapping("index/{name}")
    public List<TeacherHeaderDto> findTeacherByName(@PathVariable String name){
        return service.findTeacherByName(name);
    }

    @PostMapping("insert")
    public TeacherHeaderDto insertTeacher(@RequestBody TeacherInsertDto teacherInsertDto){
        return service.insertDataTeacher(teacherInsertDto);
    }

    @PutMapping("update/{id}")
    public TeacherHeaderDto updateTeacher(@PathVariable Integer id, @RequestBody TeacherUpdateDto teacher){
        return service.updateDataTeacher(id,teacher);
    }

    @DeleteMapping("delete/{id}")
    public List<TeacherHeaderDto> deleteTeacher(@PathVariable Integer id){
        return service.deleteTeacherById(id);
    }

}
