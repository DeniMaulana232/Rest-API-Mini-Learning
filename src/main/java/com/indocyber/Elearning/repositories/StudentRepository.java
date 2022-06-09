package com.indocyber.Elearning.repositories;

import com.indocyber.Elearning.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
