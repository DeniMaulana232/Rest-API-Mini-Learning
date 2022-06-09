package com.indocyber.Elearning.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ClassId", nullable = false)
    private RoomClass roomClass;

    @Column(name = "FirstName", nullable = false, length = 20)
    private String firstName;

    @Column(name = "LastName", length = 50)
    private String lastName;

    @Column(name = "NIK", length = 100)
    private String nik;

    @Column(name = "Address", length = 100)
    private String address;

    @OneToMany(mappedBy = "student")
    private Set<Score> scores = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "YearsId", nullable = false)
    private SchoolYear years;

    public Student(Integer roomClass, String firstName, String lastName, String nik, String address, Integer years) {
        this.roomClass = new RoomClass(roomClass);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nik = nik;
        this.address = address;
        this.years = new SchoolYear(years);
    }

    public void setRoomClass(Integer roomClass) {
        this.roomClass = new RoomClass(roomClass);
    }

    public Student(Integer id) {
        this.id = id;
    }
}