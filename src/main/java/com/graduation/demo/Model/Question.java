package com.graduation.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
    @Id
    private Long id;
    private String question;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonIgnore
    private Set<Answer> answer;
    @ManyToOne
    @JoinColumn(name = "exame_id",referencedColumnName = "id")
    private Exam exame;
}
