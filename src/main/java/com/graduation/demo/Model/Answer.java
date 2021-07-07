package com.graduation.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "Details about the Answer")
@ToString(exclude = {"exam","student"})
public class Answer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique id of the answer")
    private Long id;
    @ApiModelProperty(notes = "The content of answer")
    private  String answer;
    @ApiModelProperty(notes = "The Date of answer")
    private Date date;
    @ApiModelProperty(notes = "The Status of answer")
    private boolean passed;



    @ManyToOne
    @JoinColumn(name ="exam_id",referencedColumnName = "id")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name ="student_id",referencedColumnName = "id")
    private Student student;

private  int totalDegree;

private  int studentDegree;

}
