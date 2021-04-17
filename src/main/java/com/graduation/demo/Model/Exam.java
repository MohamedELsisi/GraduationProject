package com.graduation.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Date date;
    private Date start_time;
    private int  time;
    private String Doctor_name;
    private int question_num;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "exam")
    @JsonIgnore
    private Degree degree;
    @OneToMany(mappedBy = "exame")
    private Set<Question> questiont;
    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;
}
