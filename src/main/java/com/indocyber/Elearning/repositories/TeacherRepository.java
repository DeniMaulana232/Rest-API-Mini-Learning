package com.indocyber.Elearning.repositories;

import com.indocyber.Elearning.dtos.Teacher.TeacherHeaderDto;
import com.indocyber.Elearning.dtos.Teacher.TeacherInsertDto;
import com.indocyber.Elearning.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    @Query(value = """
            SELECT * FROM Teacher
            WHERE CONCAT(FirstName, ' ', LastName) LIKE %:name%
            """, nativeQuery = true)
    List<Teacher> findTeacherByName(@Param("name") String name);


}
