package com.graduation.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int grade;
    private int passed_value;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<Exam> exam;

    @OneToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<StudentAndCourse> studentAndCourses;
    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private Doctor doctor;
}
