package com.graduation.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "Details about the Answer")
public class Answer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique id of the answer")
    private Long id;
    @ApiModelProperty(notes = "The content of answer")
    private  String answer;
    @ManyToOne
    @JoinColumn(name ="question_id",referencedColumnName = "id")
    private Question question;


}
