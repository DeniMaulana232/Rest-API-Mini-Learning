package com.indocyber.Elearning.services;

import com.indocyber.Elearning.dtos.SchoolYear.SchoolYearHeaderDto;
import com.indocyber.Elearning.dtos.SchoolYear.SchoolYearInsertDto;
import com.indocyber.Elearning.dtos.SchoolYear.SchoolYearUpdateDto;
import com.indocyber.Elearning.models.SchoolYear;
import com.indocyber.Elearning.repositories.SchoolYearRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class SchoolYearService {
    private SchoolYearRepository repository;

    @Autowired
    public SchoolYearService(SchoolYearRepository repository) {
        this.repository = repository;
    }

    //get all
    public List<SchoolYearHeaderDto> getAllSchoolYear() {
        return SchoolYearHeaderDto.toList(repository.findAll());
    }

    //insert
    public SchoolYearHeaderDto insertSchoolYear(SchoolYearInsertDto dto) {
        SchoolYear schoolYear = dto.convert();
        repository.save(schoolYear);
        return SchoolYearHeaderDto.set(schoolYear);
    }


    public List<SchoolYearHeaderDto> findByYear(String year) {
        List<SchoolYearHeaderDto> years = SchoolYearHeaderDto.toList(repository.findByYear(year));
        if (years.stream().toList().isEmpty()) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "SchoolYear not found");
        }
        return years;
    }

    //update
    public SchoolYearUpdateDto updateSchoolYear(Integer id , SchoolYearUpdateDto dto) {
        SchoolYear schoolYear = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "SchoolYear not found"));
        schoolYear.setNewYear(dto.getYear() != null ? dto.getYear() : schoolYear.getYears().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        schoolYear.setSemester(dto.getSemester() == null ? schoolYear.getSemester() : dto.getSemester());
        repository.save(schoolYear);
        return SchoolYearUpdateDto.set(schoolYear);
    }

    public List<SchoolYearHeaderDto> deleteSchoolYear(Integer id) {
        repository.deleteById(id);
        return SchoolYearHeaderDto.toList(repository.findAll());
    }


}