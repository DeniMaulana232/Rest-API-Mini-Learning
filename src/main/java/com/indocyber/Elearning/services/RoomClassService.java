package com.indocyber.Elearning.services;

import com.indocyber.Elearning.dtos.RoomClass.RoomClassHeaderDto;
import com.indocyber.Elearning.dtos.RoomClass.RoomClassInsertDto;
import com.indocyber.Elearning.dtos.RoomClass.RoomClassUpdateDto;
import com.indocyber.Elearning.dtos.Student.StudentUpdateDto;
import com.indocyber.Elearning.models.RoomClass;
import com.indocyber.Elearning.models.Student;
import com.indocyber.Elearning.repositories.RoomClassRepository;
import com.indocyber.Elearning.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoomClassService {
    private RoomClassRepository roomClassRepository;
    private TeacherRepository teacherRepository;

    @Autowired
    public RoomClassService(RoomClassRepository roomClassRepository, TeacherRepository teacherRepository) {
        this.roomClassRepository = roomClassRepository;
        this.teacherRepository = teacherRepository;
    }


    public List<RoomClassHeaderDto> findAllRoomClass() {
        return RoomClassHeaderDto.toList(roomClassRepository.findAll());
    }

    public RoomClassHeaderDto findRoomClassById(Integer id) {
        return RoomClassHeaderDto.set(roomClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomClass not found")));
    }


    public RoomClassHeaderDto insertRoomClass(RoomClassInsertDto insertDto) {
        boolean isTeacherExist = roomClassRepository.findByTeacher_id(insertDto.getTeacherName()).isPresent();
        if (isTeacherExist) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "guru sudah memiliki kelas");
        }

        RoomClass roomClass = insertDto.convert();
        roomClassRepository.save(roomClass);
        return RoomClassHeaderDto.set(roomClass);

    }

    public RoomClassHeaderDto updateRoomClass(Integer id, RoomClassUpdateDto updateDto) {
        RoomClass roomClass = roomClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room Class not found"));


        roomClass.setClassName(updateDto.getClassName() == null ? roomClass.getClassName() : updateDto.getClassName());
        roomClass.setTeacher(updateDto.getTeacherName() == null ? roomClass.getTeacher().getId() : updateDto.getTeacherName());
        roomClassRepository.save(roomClass);
        return RoomClassHeaderDto.set(roomClass);
    }



    public List<RoomClassHeaderDto> deleteRoomById(Integer id) {
        roomClassRepository.deleteById(id);
        return RoomClassHeaderDto.toList(roomClassRepository.findAll());
    }


}
