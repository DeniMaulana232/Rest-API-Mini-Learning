package com.indocyber.Elearning.dtos.SchoolYear;
import com.indocyber.Elearning.models.SchoolYear;
import lombok.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class SchoolYearInsertDto {
    private final Integer id;
    private final String schoolYear;
    private final Integer semester;


    public SchoolYear convert(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        SchoolYear insert = new SchoolYear(id,LocalDate.parse(schoolYear,formatter),semester);
        return insert;
    }
}

