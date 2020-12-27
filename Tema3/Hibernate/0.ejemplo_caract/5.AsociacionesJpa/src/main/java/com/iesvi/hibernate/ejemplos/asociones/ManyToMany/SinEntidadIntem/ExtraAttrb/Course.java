package com.iesvi.hibernate.ejemplos.asociones.ManyToMany.SinEntidadIntem.ExtraAttrb;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double fee;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    /* Getters and setters */
}