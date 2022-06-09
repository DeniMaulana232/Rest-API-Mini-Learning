package com.indocyber.Elearning.repositories;

import com.indocyber.Elearning.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, String> {
    Optional<Object> findByTeacher_id(Integer teacherId);

    @Query(value = """
            SELECT * FROM Subject
            WHERE SubjectId = :id
            """, nativeQuery = true)
    Optional<Subject> findSubjectById(String id);

}
