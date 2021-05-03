package com.graduation.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Details about the Exam ")

public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(notes = "The unique id of the Exam")
    private Long id;
    @ApiModelProperty(notes = "The Date of Exam")
    private Date date;
    @ApiModelProperty(notes = "The Start time  of Exam")
    private Date start_time;
    @ApiModelProperty(notes = "The time  of Exam")
    private int  time;
    @ApiModelProperty(notes = "The name of Doctor ")
    private String Doctor_name;
    @ApiModelProperty(notes = "The number of Questions")
    private int question_num;
    @ApiModelProperty(notes = "The name of Course ")
    private  String course_name;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "exam")
    @JsonIgnore
    private Degree degree;
    @OneToMany(mappedBy = "exame")
    @JsonIgnore
    private Set<Question> questiont;
    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;






















}
