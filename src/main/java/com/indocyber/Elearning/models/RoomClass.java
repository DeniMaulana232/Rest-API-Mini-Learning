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
public class RoomClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClassId", nullable = false)
    private Integer id;

    @Column(name = "ClassName", nullable = false, length = 20)
    private String className;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TeacherId", nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "roomClass")
    private Set<Student> students = new LinkedHashSet<>();

    public RoomClass(String className, Integer teacher) {
        this.className = className;
        this.teacher = new Teacher(teacher);
    }

    public void setTeacher(Integer teacher) {
        this.teacher = new Teacher(teacher);
    }

    public RoomClass(Integer id) {
        this.id = id;
    }
}