package com.indocyber.Elearning.repositories;

import com.indocyber.Elearning.models.RoomClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomClassRepository extends JpaRepository<RoomClass, Integer> {


    Optional<Object> findByTeacher_id(Integer teacherId);
}
