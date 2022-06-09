package com.indocyber.Elearning.dtos.Teacher;

import com.indocyber.Elearning.models.Teacher;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TeacherHeaderDto {
    private final Integer id;
    private final String nuptk;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final String phone;

    public static TeacherHeaderDto set(Teacher teacher){
        return new TeacherHeaderDto(
                teacher.getId(),
                teacher.getNuptk(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getEmail(),
                teacher.getAddress(),
                teacher.getPhone()
        );
    }

    public static List<TeacherHeaderDto> toList(List<Teacher> teachers){
        List<TeacherHeaderDto> result = new ArrayList<>();
        for(Teacher teacher : teachers){
            result.add(set(teacher));
        }

        return result;
    }
}
