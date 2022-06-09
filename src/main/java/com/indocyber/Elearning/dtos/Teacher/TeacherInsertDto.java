package com.indocyber.Elearning.dtos.Teacher;

import com.indocyber.Elearning.models.Teacher;
import lombok.Data;

@Data
public class TeacherInsertDto {
    private final String nuptk;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final String phone;

    public Teacher convert(){
        Teacher teacher = new Teacher(nuptk,firstName,lastName,email,address,phone);
        return teacher;
    }
}
