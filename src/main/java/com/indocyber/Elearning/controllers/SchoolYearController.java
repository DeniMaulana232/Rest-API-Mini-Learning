package com.indocyber.Elearning.controllers;

import com.indocyber.Elearning.dtos.SchoolYear.SchoolYearHeaderDto;
import com.indocyber.Elearning.dtos.SchoolYear.SchoolYearInsertDto;
import com.indocyber.Elearning.dtos.SchoolYear.SchoolYearUpdateDto;
import com.indocyber.Elearning.services.SchoolYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("year")
public class SchoolYearController {
    private SchoolYearService service;

    @Autowired
    public SchoolYearController(SchoolYearService service) {
        this.service = service;
    }

    //get all
    @GetMapping("index")
    public List<SchoolYearHeaderDto> getAllSchoolYear() {
        return service.getAllSchoolYear();
    }

    @GetMapping("index/year/{year}")
    public List<SchoolYearHeaderDto> findByYear(@PathVariable String year) {
        return service.findByYear(year);
    }

    @PostMapping("insert")
    public SchoolYearHeaderDto insertSchoolYear(@RequestBody SchoolYearInsertDto dto) {
        return service.insertSchoolYear(dto);
    }

    //update
    @PutMapping("update")
    public SchoolYearUpdateDto   updateSchoolYear(@RequestParam Integer id, @RequestBody SchoolYearUpdateDto dto) {
        return service.updateSchoolYear(id, dto);
    }

    //delete
    @DeleteMapping("delete")
    public List<SchoolYearHeaderDto> deleteSchoolYear(@RequestParam Integer id) {
        return service.deleteSchoolYear(id);
    }
}
