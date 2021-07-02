package com.graduation.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "Details about the Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique id of the course")
    private Long id;
    @ApiModelProperty(notes = "The name of Course")
    private String name;
    @ApiModelProperty(notes = "The grade of Course")
    private int grade;
    @ApiModelProperty(notes = "The passed grade of Course")
    private int passed_value;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<Exam> exam;

    @OneToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<StudentAndCourse> studentAndCourses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private Doctor doctor;
}
