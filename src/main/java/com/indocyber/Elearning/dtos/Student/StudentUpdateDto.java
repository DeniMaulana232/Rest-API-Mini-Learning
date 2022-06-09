package com.indocyber.Elearning.dtos.Student;

import com.indocyber.Elearning.models.RoomClass;
import com.indocyber.Elearning.models.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateDto {
    private String firstName;
    private String lastName;
    private String nik;
    private String address;
    private Integer room;

    public static StudentUpdateDto convert(Student student){
        return new StudentUpdateDto(
                student.getFirstName(),
                student.getLastName(),
                student.getNik(),
                student.getAddress(),
                student.getRoomClass().getId()
        );
    }
}
