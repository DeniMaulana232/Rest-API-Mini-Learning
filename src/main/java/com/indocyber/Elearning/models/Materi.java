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
public class Materi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MateriId", nullable = false)
    private Integer id;

    @Column(name = "Title", nullable = false, length = 200)
    private String title;

    @Column(name = "Description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SubjectId", nullable = false)
    private Subject subject;

    public Materi(String title, String description, String subject) {
        this.title = title;
        this.description = description;
        this.subject = new Subject(subject);
    }

    public void setSubject(String subject) {
        this.subject = new Subject(subject);
    }
}