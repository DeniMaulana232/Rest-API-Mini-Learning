package com.indocyber.Elearning.services;

import com.indocyber.Elearning.dtos.Score.ScoreGridDto;
import com.indocyber.Elearning.dtos.Score.ScoreHeaderDto;
import com.indocyber.Elearning.dtos.Score.ScoreInsertDto;
import com.indocyber.Elearning.dtos.Score.ScoreUpdateDto;
import com.indocyber.Elearning.models.Score;
import com.indocyber.Elearning.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ScoreService {
    private ScoreRepository repository;

    @Autowired
    public ScoreService(ScoreRepository repository) {
        this.repository = repository;
    }

    //get all
    public List<ScoreHeaderDto> getAll() {
        return ScoreHeaderDto.toList(repository.findAll());
    }

    public List<ScoreGridDto> findStudentScore(String name) {
        return ScoreGridDto.toList(repository.findStudentScore(name));
    }

    public List<ScoreGridDto> findScoreByClassAndSubject(String roomClass, String subjectName) {
        return ScoreGridDto.toList(repository.findScoreByClassAndSubject(roomClass, subjectName));
    }

    //insert
    public ScoreInsertDto insertScore(ScoreInsertDto dto) {
        Score score = dto.convert();
        repository.save(score);
        return ScoreInsertDto.set(score);
    }

    //update
    public ScoreUpdateDto updateScore(Integer id,ScoreUpdateDto dto) {
        Score oldScore = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Score not found")
        );

        oldScore.setValue(dto.getValue() == null ? oldScore.getValue() : dto.getValue());
        oldScore.setStudent(dto.getStudentId() == null ? oldScore.getStudent().getId() : dto.getStudentId());
        repository.save(oldScore);
        return ScoreUpdateDto.toList(oldScore);
    }

    //delete
    public void deleteScore(Integer id) {
        repository.deleteById(id);
    }
}
