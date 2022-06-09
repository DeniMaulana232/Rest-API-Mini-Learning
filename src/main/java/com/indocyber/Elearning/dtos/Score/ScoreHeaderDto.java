package com.indocyber.Elearning.dtos.Score;

import com.indocyber.Elearning.models.Score;
import lombok.Data;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
public class ScoreHeaderDto implements Serializable {
    private final Integer id;
    private final Integer value;
    private final String studentRoomClassClassName;
    private final String studentFirstName;
    private final String  yearsYears;
    private final Integer yearsSemester;
    private final String subjectSubjectName;
    private final String subjectDescription;
    private final String techer;

    public static ScoreHeaderDto set(Score score){
        return new ScoreHeaderDto(
                score.getId(),
                score.getValue(),
                score.getStudent().getRoomClass().getClassName(),
                score.getStudent().getFirstName() + " " + score.getStudent().getLastName(),
                score.getYears().getYears().format(DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id","ID"))),
                score.getYears().getSemester(),
                score.getSubject().getSubjectName(),
                score.getSubject().getDescription(),
                score.getSubject().getTeacher().getFirstName() + " " + score.getSubject().getTeacher().getLastName()
        );
    }

    public static List<ScoreHeaderDto> toList(List<Score> scoreList){
        List<ScoreHeaderDto> result = new ArrayList<>();
        for (Score score : scoreList) {
            result.add(set(score));
        }
        return result;
    }
}
