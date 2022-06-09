package com.indocyber.Elearning.dtos.SchoolYear;

import com.indocyber.Elearning.dtos.RoomClass.RoomClassHeaderDto;
import com.indocyber.Elearning.models.RoomClass;
import com.indocyber.Elearning.models.SchoolYear;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class SchoolYearHeaderDto implements Serializable {
    private final Integer id;
    private final LocalDate schoolYear;
    private final Integer semester;


    public static SchoolYearHeaderDto set(SchoolYear year){
        return new SchoolYearHeaderDto(
                year.getId(),
                year.getYears(),
                year.getSemester()
        );
    }

    public static List<SchoolYearHeaderDto> toList(List<SchoolYear> years) {
        List<SchoolYearHeaderDto> result = new ArrayList<>();
        for (SchoolYear schoolYear : years) {
            result.add(set(schoolYear));
        }
        return result;
    }
}
