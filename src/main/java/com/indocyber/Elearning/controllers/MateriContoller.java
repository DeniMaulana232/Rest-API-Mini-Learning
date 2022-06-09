package com.indocyber.Elearning.controllers;

import com.indocyber.Elearning.dtos.Materi.MateriHeaderDto;
import com.indocyber.Elearning.dtos.Materi.MateriInsertDto;
import com.indocyber.Elearning.dtos.Materi.MateriUpdateDto;
import com.indocyber.Elearning.models.Materi;
import com.indocyber.Elearning.services.MateriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materi")
public class MateriContoller {
    private MateriService service;

    @Autowired
    public MateriContoller(MateriService service) {
        this.service = service;
    }

    @GetMapping("index")
    public List<MateriHeaderDto> findAllMateri(){
        return service.findAllMateri();
    }

    @PostMapping("insert")
    public MateriInsertDto insertNewMateri(@RequestBody MateriInsertDto insertDto){
        return service.insertNewMateri(insertDto);
    }

    @PutMapping("{id}")
    public MateriUpdateDto updateMateri(@PathVariable Integer id, @RequestBody MateriUpdateDto updateDto){
       return service.UpdateMateri(id,updateDto);
    }

    @DeleteMapping("delete/{id}")
    public List<MateriHeaderDto> deleteMateriById(@PathVariable Integer id){
       return service.deleteMateriById(id);
    }
}
