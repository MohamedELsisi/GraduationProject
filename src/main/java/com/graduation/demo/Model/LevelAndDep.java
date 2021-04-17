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
public class LevelAndDep {
    @Id
    private Long id;


    @OneToOne
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private Level level;
    @OneToOne

    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToMany(mappedBy = "levelAndDep")
    @JsonIgnore
    private Set<Student> student;
}
