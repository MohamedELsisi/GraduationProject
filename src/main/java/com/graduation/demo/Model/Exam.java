package com.graduation.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exam {
    @Id
    private Long id;
    private Long course_id;
    private Date date;
    private Date start_time;
    private int  time;
    private String Doctor_name;
    private int question_num;

    @OneToOne
    private Degree degree;
    @OneToMany
    private Set<Question> questiont;
    @ManyToOne
    private Course course;
}
