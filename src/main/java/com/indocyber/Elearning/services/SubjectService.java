package com.indocyber.Elearning.services;

import com.indocyber.Elearning.dtos.Subject.SubjectDto;
import com.indocyber.Elearning.dtos.Subject.SubjectHeaderDto;
import com.indocyber.Elearning.dtos.Subject.SubjectInsertDto;
import com.indocyber.Elearning.dtos.Subject.SubjectUpdateDto;
import com.indocyber.Elearning.dtos.Teacher.TeacherHeaderDto;
import com.indocyber.Elearning.models.Subject;
import com.indocyber.Elearning.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectHeaderDto> findAllSubject() {
        return SubjectHeaderDto.toList(subjectRepository.findAll());
    }

    public SubjectHeaderDto findSubjectById(String id) {
        return SubjectHeaderDto.set(subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found")));
    }

    public SubjectHeaderDto insertSubject(SubjectInsertDto insertDto) {
        var isTeacherExist = subjectRepository.findByTeacher_id(insertDto.getTeacherName()).isPresent();
        if (isTeacherExist) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "guru telah mempunyai mata pelajaran yang di ampu");
        }

        var isSubjectExist = subjectRepository.findSubjectById(insertDto.getSubjectName()).isPresent();
        if (isSubjectExist) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mata pelajaran sudah ada");
        }
        Subject subject = new Subject(
                insertDto.getId(),
                insertDto.getSubjectName(),
                insertDto.getDescription(),
                insertDto.getTeacherName()
        );
        subjectRepository.save(subject);
        return SubjectHeaderDto.set(subject);
    }

    public SubjectUpdateDto updateSubject(String id, SubjectUpdateDto insertDto) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST ,"Subject not found"));
        subject.setSubjectName(insertDto.getSubjectName() == null ? subject.getSubjectName() : insertDto.getSubjectName());
        subject.setDescription(insertDto.getDescription() == null ? subject.getDescription() : insertDto.getDescription());
        subject.setTeacher(insertDto.getTeacherName() == null ? subject.getTeacher().getId() : Integer.valueOf(insertDto.getTeacherName()));
        subjectRepository.save(subject);
        return SubjectUpdateDto.convert(subject);
    }


    public List<SubjectHeaderDto> deleteTeacherById(String id){
        subjectRepository.deleteById(id);
        return SubjectHeaderDto.toList(subjectRepository.findAll());
    }
}
