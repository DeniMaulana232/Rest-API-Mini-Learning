package com.indocyber.Elearning.controllers;

import com.indocyber.Elearning.dtos.Score.ScoreGridDto;
import com.indocyber.Elearning.dtos.Score.ScoreHeaderDto;
import com.indocyber.Elearning.dtos.Score.ScoreInsertDto;
import com.indocyber.Elearning.dtos.Score.ScoreUpdateDto;
import com.indocyber.Elearning.models.Score;
import com.indocyber.Elearning.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("score")
public class ScoreController {
    private ScoreService service;

    @Autowired
    public ScoreController(ScoreService service) {
        this.service = service;
    }

    @GetMapping("index")
    public List<ScoreHeaderDto> getAll() {
        return service.getAll();
    }

    @GetMapping("index/{name}")
    public List<ScoreGridDto> findStudentScore(@PathVariable String name) {
        return service.findStudentScore(name);
    }

    @GetMapping("index/by")
    public List<ScoreGridDto> findScoreByClassAndSubject(@RequestParam String roomClass, @RequestParam String subjectName) {
        return service.findScoreByClassAndSubject(roomClass, subjectName);
    }

    @PostMapping("insert")
    public ScoreInsertDto insertScore(@RequestBody ScoreInsertDto dto) {
        return service.insertScore(dto);
    }

    @PutMapping("update/{id}")
    public ScoreUpdateDto updateScore(@PathVariable Integer id, @RequestBody ScoreUpdateDto dto) {
        return service.updateScore(id, dto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteScore(@PathVariable Integer id) {
        service.deleteScore(id);
    }
}
