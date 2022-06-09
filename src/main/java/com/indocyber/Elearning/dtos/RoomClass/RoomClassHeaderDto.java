package com.indocyber.Elearning.dtos.RoomClass;

import com.indocyber.Elearning.models.RoomClass;
import com.indocyber.Elearning.models.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class RoomClassHeaderDto implements Serializable {
    private final Integer id;
    private final String className;
    private final String HomeRoomTeacher;

    public static RoomClassHeaderDto set(RoomClass roomClass){
        return new RoomClassHeaderDto(
                roomClass.getId(),
                roomClass.getClassName(),
                roomClass.getTeacher().getFirstName() + " " + roomClass.getTeacher().getLastName()
        );
    }
    public static List<RoomClassHeaderDto> toList(List<RoomClass> roomClasses) {
        List<RoomClassHeaderDto> result = new ArrayList<>();
        for (RoomClass roomClass : roomClasses) {
            result.add(set(roomClass));
        }
        return result;
    }
}
