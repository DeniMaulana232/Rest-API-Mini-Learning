package com.indocyber.Elearning.repositories;

import com.indocyber.Elearning.models.Materi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MateriRepository extends JpaRepository<Materi, Integer> {

    @Query(value = """
            SELECT TOP 1 * FROM Materi
            order by MateriId desc
            """, nativeQuery = true)
    List<Materi> findMateriTopOne();
}
