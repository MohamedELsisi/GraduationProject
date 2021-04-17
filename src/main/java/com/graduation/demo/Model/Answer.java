package com.graduation.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private  String answer;
    @ManyToOne
    @JoinColumn(name ="question_id",referencedColumnName = "id")
    private Question question;


}
