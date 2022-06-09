package com.indocyber.Elearning.dtos.SchoolYear;

import com.indocyber.Elearning.models.SchoolYear;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class SchoolYearUpdateDto {
    private final String year;
    private final Integer semester;

    public static SchoolYearUpdateDto set(SchoolYear year){
        return new SchoolYearUpdateDto(
                year.getYears().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                year.getSemester()
        );
    }

}
