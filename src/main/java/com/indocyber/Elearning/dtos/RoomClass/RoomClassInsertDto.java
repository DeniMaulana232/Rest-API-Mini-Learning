package com.indocyber.Elearning.dtos.RoomClass;

import com.indocyber.Elearning.models.RoomClass;
import lombok.Data;

@Data
public class RoomClassInsertDto {
    private String className;
    private Integer teacherName;

    public RoomClass convert(){
        RoomClass insert = new RoomClass(className,teacherName);
        return insert;
    }
}
