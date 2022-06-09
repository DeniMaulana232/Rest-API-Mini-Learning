package com.indocyber.Elearning.services;

import com.indocyber.Elearning.dtos.Materi.MateriHeaderDto;
import com.indocyber.Elearning.dtos.Materi.MateriInsertDto;
import com.indocyber.Elearning.dtos.Materi.MateriUpdateDto;
import com.indocyber.Elearning.dtos.RoomClass.RoomClassHeaderDto;
import com.indocyber.Elearning.dtos.RoomClass.RoomClassUpdateDto;
import com.indocyber.Elearning.models.Materi;
import com.indocyber.Elearning.models.RoomClass;
import com.indocyber.Elearning.repositories.MateriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MateriService {
    private MateriRepository materiRepository;

    @Autowired
    public MateriService(MateriRepository materiRepository) {
        this.materiRepository = materiRepository;
    }

    public List<MateriHeaderDto> findAllMateri(){
        return MateriHeaderDto.toList(materiRepository.findAll());
    }

    public MateriHeaderDto findMateriById(Integer id){
        return MateriHeaderDto.set(materiRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "materi tidak ditemukan")));
    }

    public MateriInsertDto insertNewMateri(MateriInsertDto insertDto){
        Materi materi = new Materi(
                insertDto.getTitle(),
                insertDto.getDescription(),
                insertDto.getSubjectId()
        );

        materiRepository.save(materi);

        return MateriInsertDto.toList(materi);
    }

    public MateriUpdateDto UpdateMateri(Integer id, MateriUpdateDto updateDto) {
        Materi oldMateri = materiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room Class not found"));


        oldMateri.setTitle(updateDto.getTitle() == null ? oldMateri.getTitle() : updateDto.getTitle());
        oldMateri.setDescription(updateDto.getDescription() == null ? oldMateri.getDescription() : updateDto.getDescription());
        oldMateri.setSubject(updateDto.getSubjectId() == null ? oldMateri.getSubject().getId() : updateDto.getSubjectId());
        materiRepository.save(oldMateri);
        return MateriUpdateDto.toList(oldMateri);
    }


    public List<MateriHeaderDto> deleteMateriById(Integer id){
        materiRepository.deleteById(id);
        return MateriHeaderDto.toList(materiRepository.findAll());
    }

}
