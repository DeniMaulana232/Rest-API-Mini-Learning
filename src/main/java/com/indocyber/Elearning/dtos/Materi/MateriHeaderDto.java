package com.indocyber.Elearning.dtos.Materi;

import com.indocyber.Elearning.models.Materi;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class MateriHeaderDto implements Serializable {
    private final Integer id;
    private final String title;
    private final String description;
    private final String subjectId;


    public static MateriHeaderDto set(Materi materi){
        return new MateriHeaderDto(materi.getId(),
                materi.getTitle(),
                materi.getDescription(),
                materi.getSubject().getSubjectName());
    }

    public static List<MateriHeaderDto> toList(List<Materi> materiList){
        List<MateriHeaderDto> result = new ArrayList<>();
        for (Materi materi : materiList) {
            result.add(set(materi));
        }
        return result;
    }
}
