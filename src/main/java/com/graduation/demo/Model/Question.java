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
@ApiModel(description = "Details about the Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique id of the Question")
    private Long id;
    @ApiModelProperty(notes = "The content of Question")
    private String question;


   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonIgnore
    private Set<Answer> answer;
    @ManyToOne
    @JoinColumn(name = "exame_id",referencedColumnName = "id")
    private Exam exame;*/























}
