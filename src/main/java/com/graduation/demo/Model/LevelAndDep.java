package com.graduation.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LevelAndDep {
    @Id
    private Long id;


    @OneToMany
    @JoinColumn( name = "levai_Dep_id",referencedColumnName = "id")
    //@JoinColumn(name = "level_id", referencedColumnName = "id")
    private List<Level> level;

    @OneToMany
    @JoinColumn( name = "levai_Dep_id",referencedColumnName = "id")
    private List<Department> department;

    @OneToMany(mappedBy = "levelAndDep")
    @JsonIgnore
    private Set<Student> student;
}
