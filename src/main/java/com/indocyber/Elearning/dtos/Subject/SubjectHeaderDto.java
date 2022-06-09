package com.indocyber.Elearning.dtos.Subject;

import com.indocyber.Elearning.models.Subject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubjectHeaderDto {
    private final String id;
    private final String subjectName;
    private final String description;
    private final String teacherName;

    public static SubjectHeaderDto set(Subject subject) {
        return new SubjectHeaderDto(
                subject.getId(),
                subject.getSubjectName(),
                subject.getDescription(),
                subject.getTeacher().getFirstName() + " " + subject.getTeacher().getLastName()
        );
    }

    public static List<SubjectHeaderDto> toList(List<Subject> subjects) {
        List<SubjectHeaderDto> result = new ArrayList<>();
        for (Subject subject : subjects) {
            result.add(set(subject));
        }
        return result;
    }

}
