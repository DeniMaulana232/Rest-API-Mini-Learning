package com.indocyber.Elearning.dtos.Student;

import com.indocyber.Elearning.models.Student;
import lombok.Data;

@Data
public class StudentInsertDto {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String nik;
    private final String address;
    private final Integer RoomClass;
    private final Integer yearsId;


    public static StudentInsertDto convert(Student student){
        return new StudentInsertDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getNik(),
                student.getAddress(),
                student.getRoomClass().getId(),
                student.getYears().getId()
        );
    }
}
