package com.graduation.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Long student_id;

    @OneToOne
    @JoinColumn(name = "exam_id",referencedColumnName = "id")
    private Exam exam;


}
