package com.indocyber.Elearning.dtos.Teacher;

import lombok.Data;

@Data
public class TeacherUpdateDto {
    private final String nuptk;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final String phone;

}
