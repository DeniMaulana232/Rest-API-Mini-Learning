package com.indocyber.Elearning.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScoreId", nullable = false)
    private Integer id;

    @Column(name = "\"value\"", nullable = false)
    private Integer value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "YearsId", nullable = false)
    private SchoolYear years;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "StudentId", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SubjectId", nullable = false)
    private Subject subject;

    public Score(Integer id, Integer value,Integer studentId ,Integer years, String subject) {
        this.id = id;
        this.value = value;
        this.years = new SchoolYear(years);
        this.subject = new Subject(subject);
        this.student = new Student(studentId);
    }

    public void setStudent(Integer student) {
        this.student = new Student(student);
    }

    public void setSubject(String subject) {
        this.subject = new Subject(subject);
    }
}