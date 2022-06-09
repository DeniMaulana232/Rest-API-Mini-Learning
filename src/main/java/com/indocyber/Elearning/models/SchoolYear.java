package com.indocyber.Elearning.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SchoolYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "YearsId", nullable = false)
    private Integer id;

    @Column(name = "YearsDate", nullable = false)
    private LocalDate years;

    @Column(name = "Semester", nullable = false)
    private Integer semester;

    @OneToMany(mappedBy = "years")
    private Set<Score> scores = new LinkedHashSet<>();

    @OneToMany(mappedBy = "years")
    private Set<Student> students = new LinkedHashSet<>();

    public SchoolYear(Integer id,LocalDate years, Integer semester) {
        this.id = id;
        this.years = years;
        this.semester = semester;
    }

    public SchoolYear(Integer id) {
        this.id = id;
    }

    public void setNewYear(String year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.years = LocalDate.parse(year, formatter);
    }
}