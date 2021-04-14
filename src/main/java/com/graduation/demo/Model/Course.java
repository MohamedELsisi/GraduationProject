package com.graduation.demo.Model;

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
    @GeneratedValue
    private Long id;
    private String name;
    private int grade;
    private int passed_value;

    @OneToMany
    private Set <Exam> exam;

    @ManyToMany
    private  Set<Student>students;
}
