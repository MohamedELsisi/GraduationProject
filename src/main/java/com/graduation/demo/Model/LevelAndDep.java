package com.graduation.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"student"})
public class LevelAndDep {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private Level level;

    @ManyToOne
    @JoinColumn( name = "department_id",referencedColumnName = "id")
    private  Department department;

    @OneToMany(mappedBy = "levelAndDep")
    @JsonIgnore
    private Set<Student> student;
}
