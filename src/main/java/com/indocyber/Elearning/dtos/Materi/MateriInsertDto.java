package com.indocyber.Elearning.dtos.Materi;

import com.indocyber.Elearning.models.Materi;
import lombok.Data;

import java.io.Serializable;

@Data
public class MateriInsertDto implements Serializable {
    private final String title;
    private final String description;
    private final String subjectId;

    public Materi convert(){
        Materi result = new Materi(title,description,subjectId);
        return result;
    }

    public static MateriInsertDto toList(Materi materi){
        return new MateriInsertDto(
                materi.getTitle(),
                materi.getDescription() ,
                materi.getSubject().getId()
        );
    }

}
