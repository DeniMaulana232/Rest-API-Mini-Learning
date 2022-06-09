package com.indocyber.Elearning.controllers;

import com.indocyber.Elearning.dtos.RoomClass.RoomClassHeaderDto;
import com.indocyber.Elearning.dtos.RoomClass.RoomClassInsertDto;
import com.indocyber.Elearning.dtos.RoomClass.RoomClassUpdateDto;
import com.indocyber.Elearning.dtos.Teacher.TeacherHeaderDto;
import com.indocyber.Elearning.models.RoomClass;
import com.indocyber.Elearning.services.RoomClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roomclass")
public class RoomClassController {
    private RoomClassService service;

    @Autowired
    public RoomClassController(RoomClassService service) {
        this.service = service;
    }

    @GetMapping("index")
    public List<RoomClassHeaderDto> findAllRoomClass(){
        return service.findAllRoomClass();
    }

    @GetMapping("index/{id}")
    public RoomClassHeaderDto findAllRoomClass(@PathVariable Integer id){
        return service.findRoomClassById(id);
    }

    @PostMapping("insert")
    public RoomClassHeaderDto insertRoomClass(@RequestBody RoomClassInsertDto insertDto) {
        return service.insertRoomClass(insertDto);
    }

    @PutMapping("{id}")
    public RoomClassHeaderDto updateRoomClass(@PathVariable Integer id, @RequestBody RoomClassUpdateDto updateDto) {
        return service.updateRoomClass(id,updateDto);

    }

    @DeleteMapping("delete/{id}")
    public List<RoomClassHeaderDto> deleteRoomClass(@PathVariable Integer id){
        service.deleteRoomById(id);
        return service.findAllRoomClass();
    }
}
