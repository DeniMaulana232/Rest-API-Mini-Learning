package com.indocyber.Elearning.dtos.Subject;

import lombok.Data;

@Data
public class SubjectInsertDto {
    private final String id;
    private final String subjectName;
    private final String description;
    private final Integer teacherName;

}
