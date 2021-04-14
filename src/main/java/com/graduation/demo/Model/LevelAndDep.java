package com.graduation.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LevelAndDep {
    @Id
    private Long id;
    private Long level_id;
    private Long dep_id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private Level level;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
}
