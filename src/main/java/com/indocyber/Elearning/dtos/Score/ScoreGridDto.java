package com.indocyber.Elearning.dtos.Score;

import com.indocyber.Elearning.models.Score;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
public class ScoreGridDto {
    private final Integer value;
    private final String name;
    private final String className;
    private final String subjectName;
    private final LocalDate years;
    private final String semester;

//    public static List<ScoreGridDto> convertGrid(List<ScoreGridDto> scoreGridDtos) {
//        List<ScoreGridDto> result = new ArrayList<>();
//        for (ScoreGridDto score : scoreGridDtos) {
//            result.add(new ScoreGridDto(
//                    score.getValue(),
//                    score.getName(),
//                    score.getClassName(),
//                    score.getSubjectName()
//            ));
//        }
//        return result;
//    }
    public static ScoreGridDto set(Score score){
        return new ScoreGridDto(
                score.getValue(),
                score.getStudent().getFirstName() + " " + score.getStudent().getLastName(),
                score.getStudent().getRoomClass().getClassName(),
                score.getSubject().getSubjectName(),
                score.getYears().getYears(),
                score.getYears().getSemester().toString()
        );
    }

    public static List<ScoreGridDto> toList(List<Score> scoreList){
        List<ScoreGridDto> result = new ArrayList<>();
        for (Score score : scoreList) {
            result.add(set(score));
        }
        return result;
    }
}
