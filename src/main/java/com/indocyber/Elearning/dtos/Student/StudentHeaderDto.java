package com.indocyber.Elearning.dtos.Student;

import com.indocyber.Elearning.models.Student;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentHeaderDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String nik;
    private final String address;
    private final String RoomClass;
    private final LocalDate years;

    public static StudentHeaderDto set(Student student) {
        return new StudentHeaderDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getNik(),
                student.getAddress(),
                student.getRoomClass().getClassName(),
                student.getYears().getYears()
        );
    }

    public static List<StudentHeaderDto> toList(List<Student> students) {
        List<StudentHeaderDto> result = new ArrayList<>();
        for (Student student : students) {
            result.add(set(student));
        }
        return result;
    }
}
