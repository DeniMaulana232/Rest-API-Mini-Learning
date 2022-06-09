package com.indocyber.Elearning.controllers;

import com.indocyber.Elearning.dtos.Subject.SubjectDto;
import com.indocyber.Elearning.dtos.Subject.SubjectHeaderDto;
import com.indocyber.Elearning.dtos.Subject.SubjectInsertDto;
import com.indocyber.Elearning.dtos.Subject.SubjectUpdateDto;
import com.indocyber.Elearning.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subject")
public class SubjectController {
    private SubjectService service;

    @Autowired
    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping("index")
    public List<SubjectHeaderDto> findAllSubject(){
        return service.findAllSubject();
    }

    @GetMapping("index/{id}")
    public SubjectHeaderDto findSubjectById(@PathVariable String id){
        return service.findSubjectById(id);
    }

    @PostMapping("insert")
    public SubjectHeaderDto insertSubject(@RequestBody SubjectInsertDto insertDto){
        return service.insertSubject(insertDto);
    }

    @PutMapping("update/{id}")
    public SubjectUpdateDto updateSubjectById(@PathVariable String id, @RequestBody SubjectUpdateDto updateDto){
        return service.updateSubject(id, updateDto);
    }

    @DeleteMapping("delete/{id}")
    public List<SubjectHeaderDto> deleteSubjectById(@PathVariable String id){
        return service.deleteTeacherById(id);
    }
}
