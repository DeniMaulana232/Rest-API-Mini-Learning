package com.indocyber.Elearning.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Subject")
public class Subject {
    @Id
    @Column(name = "SubjectId", nullable = false, length = 10)
    private String id;

    @Column(name = "SubjectName", nullable = false, length = 10)
    private String subjectName;

    @Column(name = "Description", length = 200)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TeacherId")
    private Teacher teacher;

    @OneToMany(mappedBy = "subject")
    private Set<Materi> materis = new LinkedHashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<Score> scores = new LinkedHashSet<>();

    public Subject(String id, String subjectName, String description, Integer teacher) {
        this.id = id;
        this.subjectName = subjectName;
        this.description = description;
        this.teacher = new Teacher(teacher);
    }

    public void setTeacher(Integer teacher) {
        this.teacher = new Teacher(teacher);
    }


    public Subject(String id) {
        this.id = id;
    }

}