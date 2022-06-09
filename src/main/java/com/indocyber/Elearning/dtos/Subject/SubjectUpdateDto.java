package com.indocyber.Elearning.dtos.Subject;

import com.indocyber.Elearning.models.Subject;
import lombok.Data;

@Data
public class SubjectUpdateDto {
    private final String subjectName;
    private final String description;
    private final String teacherName;

        public static SubjectUpdateDto convert(Subject subject){
            return new SubjectUpdateDto(
                    subject.getSubjectName(),
                    subject.getDescription(),
                    subject.getTeacher().getId().toString()
            );
        }

}
