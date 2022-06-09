package com.indocyber.Elearning.repositories;

import com.indocyber.Elearning.dtos.Score.ScoreGridDto;
import com.indocyber.Elearning.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
    @Query(value = """
            select sc.ScoreId,sc.StudentId, sc.YearsId, sc.SubjectId ,sc.[value], CONCAT(st.FirstName, ' ',st.LastName) as FullName, r.ClassName, sub.SubjectName, sy.YearsDate, sy.Semester from Score as sc
            join Students as st on sc.StudentId = st.StudentId
            join RoomClass as r on st.ClassId = r.ClassId
            join [Subject] as sub on sub.SubjectId = sc.SubjectId
            join SchoolYear as sy on sc.YearsId = sy.YearsId
            WHERE CONCAT(st.FirstName, ' ',st.LastName) LIKE %:name%
            """, nativeQuery = true)
    List<Score> findStudentScore(@Param("name") String name);

    @Query(value = """
            select sc.ScoreId,sc.StudentId, sc.YearsId, sc.SubjectId ,sc.[value], CONCAT(st.FirstName, ' ',st.LastName) as FullName, r.ClassName, sub.SubjectName, sy.YearsDate, sy.Semester from Score as sc
            join Students as st on sc.StudentId = st.StudentId
            join RoomClass as r on st.ClassId = r.ClassId
            join [Subject] as sub on sub.SubjectId = sc.SubjectId
            join SchoolYear as sy on sc.YearsId = sy.YearsId
            WHERE r.ClassName  = :roomClass AND  sub.SubjectName = :subjectName
            """,nativeQuery = true)
    List<Score> findScoreByClassAndSubject(@Param("roomClass") String name, @Param("subjectName") String subjectName);
}
