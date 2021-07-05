package com.graduation.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "Details about the Exam ")
@ToString(exclude = {"degree","course","answer"})
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(notes = "The unique id of the Exam")
    private Long id;
    @ApiModelProperty(notes = "The Date of Exam")
    private Date exam_date;
    @ApiModelProperty(notes = "The Date of Exam")
    private Date exam_over;
    @ApiModelProperty(notes = "The Start time  of Exam")
    private Date exam_time_from;
    @ApiModelProperty(notes = "The time  of Exam")
    private Date  exam_time_to;
    @ApiModelProperty(notes = "The json content of Exam")
    private String contentJson;
    @ApiModelProperty(notes = "The name of Doctor ")
    private String Doctor_name;
    @ApiModelProperty(notes = "The number of Questions")
    private int question_num;
    @ApiModelProperty(notes = "The name of Course ")
    private  String course_name;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "exam")
    @JsonIgnore
    private Degree degree;

    /*@OneToMany(mappedBy = "exame")
    @JsonIgnore
    private Set<Question> questiont;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exam")
    @JsonIgnore
    private Set<Answer> answer;






















}
