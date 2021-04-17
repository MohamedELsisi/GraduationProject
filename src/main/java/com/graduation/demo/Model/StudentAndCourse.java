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
public class StudentAndCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private  Student students;

    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course courses;

}
