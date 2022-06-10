package com.indocyber.Elearning.controllers;

import com.indocyber.Elearning.dtos.Materi.MateriHeaderDto;
import com.indocyber.Elearning.dtos.Materi.MateriInsertDto;
import com.indocyber.Elearning.dtos.Materi.MateriUpdateDto;
import com.indocyber.Elearning.dtos.RestResponse;
import com.indocyber.Elearning.models.Materi;
import com.indocyber.Elearning.services.MateriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RestResponse<List<MateriHeaderDto>>> findAllMateri() {
        return ResponseEntity.ok().body(
            new RestResponse<List<MateriHeaderDto>>(service.findAllMateri(),
                    "Success Find All Materi",
                    200
            ));
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<MateriInsertDto>>  insertNewMateri(@RequestBody MateriInsertDto insertDto){
        return ResponseEntity.ok().body(
            new RestResponse<MateriInsertDto>(service.insertNewMateri(insertDto),
                    "Success Insert New Materi",
                    200
            ));
    }

    @PutMapping("{id}")
    public ResponseEntity<RestResponse<MateriUpdateDto>> updateMateri(@PathVariable Integer id, @RequestBody MateriUpdateDto updateDto){
       return ResponseEntity.ok().body(
           new RestResponse<MateriUpdateDto>(service.UpdateMateri(id, updateDto),
                   "Success Update Materi",
                   200
           ));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RestResponse<List<MateriHeaderDto>>> deleteMateriById(@PathVariable Integer id){
        return ResponseEntity.ok().body(
            new RestResponse<List<MateriHeaderDto>>(service.deleteMateriById(id),
                    "Success Delete Materi",
                    200
            ));
    }
}
