package com.indocyber.Elearning.dtos.Materi;

import com.indocyber.Elearning.models.Materi;
import lombok.Data;

@Data
public class MateriUpdateDto {
    private final String title;
    private final String description;
    private final String subjectId;

    public static MateriUpdateDto  toList(Materi materi){
        return new MateriUpdateDto(
                materi.getTitle(),
                materi.getDescription() ,
                materi.getSubject().getId()
        );
    }
}
