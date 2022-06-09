package com.indocyber.Elearning.dtos.Score;

import com.indocyber.Elearning.models.Score;
import lombok.Data;

@Data
public class ScoreUpdateDto {
    private final Integer value;
    private final Integer studentId;
    private final String subjectId;

    //convert
    public static ScoreUpdateDto toList(Score score){
        return new ScoreUpdateDto(
                score.getValue(),
                score.getStudent().getId(),
                score.getSubject().getId()
        );
    }
}
