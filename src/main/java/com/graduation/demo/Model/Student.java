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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "students")
    private Set<StudentAndCourse> studentAndCourse;
@ManyToOne
@JoinColumn( name = "levai_Dep_id",referencedColumnName = "id")
    private LevelAndDep levelAndDep;


}
