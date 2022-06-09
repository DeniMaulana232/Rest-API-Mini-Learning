package com.indocyber.Elearning.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.PrintStream;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TeacherId", nullable = false)
    private Integer id;

    @Column(name = "NUPTK", nullable = false, length = 30)
    private String nuptk;

    @Column(name = "FirstName", nullable = false, length = 20)
    private String firstName;

    @Column(name = "LastName", length = 20)
    private String lastName;

    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Column(name = "Address", length = 200)
    private String address;

    @Column(name = "Phone", length = 15)
    private String phone;

    @OneToMany(mappedBy = "teacher")
    private Set<RoomClass> RoomClass = new LinkedHashSet<>();

    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects = new LinkedHashSet<>();


    public Teacher(String nuptk, String firstName, String lastName, String email, String address, String phone) {
       this.nuptk = nuptk;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Teacher(Integer id) {
        this.id = id;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
}