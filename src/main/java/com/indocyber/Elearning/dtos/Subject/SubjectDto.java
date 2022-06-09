package com.indocyber.Elearning.dtos.Subject;

import com.indocyber.Elearning.models.Subject;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class SubjectDto implements Serializable {
    private final String id;
    private final String subjectName;
    private final String description;
    private final String teacherId;

    public static SubjectDto convert(Subject subject) {
        return new SubjectDto(
                subject.getId(),
                subject.getSubjectName(),
                subject.getDescription(),
                subject.getTeacher().getFullName()
        );
    }

}
