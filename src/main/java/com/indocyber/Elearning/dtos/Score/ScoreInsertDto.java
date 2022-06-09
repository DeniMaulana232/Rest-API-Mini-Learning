package com.indocyber.Elearning.dtos.Score;

import com.indocyber.Elearning.models.Score;
import lombok.Data;

import java.io.Serializable;

@Data
public class ScoreInsertDto implements Serializable {
    private final Integer id;
    private final Integer value;
    private final Integer studentId;
    private final Integer yearsId;
    private final String subjectId;

    public Score convert(){
        return new Score(id,value,studentId,yearsId,subjectId);
    }

    //set
    public static ScoreInsertDto set(Score score){
        return new ScoreInsertDto(
                score.getId(),
                score.getValue(),
                score.getStudent().getId(),
                score.getYears().getId(),
                score.getSubject().getId()
        );
    }
}
