package com.indocyber.Elearning.repositories;

import com.indocyber.Elearning.models.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, Integer> {
    @Query(value = """
            SELECT * FROM SchoolYear
            WHERE YearsDate = :year
            """, nativeQuery = true)
    List<SchoolYear> findByYear(@Param("year") String year);

    @Query(value = """
            SELECT * FROM SchoolYear
            WHERE YearsDate = :year
            """, nativeQuery = true)
    SchoolYear findByYears(@Param("year") String year);
}
