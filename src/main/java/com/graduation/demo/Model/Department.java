package com.graduation.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Details about the Department")
@ToString(exclude = {"levelAndDep"})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique id of the Department")
    private Long id;
    @ApiModelProperty(notes = "The name of Department")
    private String name;


    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private Set<LevelAndDep> levelAndDep;
}
