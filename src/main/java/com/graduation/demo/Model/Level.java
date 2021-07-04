package com.graduation.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "Details about the Level")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique id of the Level")
    private Long  id;

    @ApiModelProperty(notes = "The name of Level")
    private String name;

    @ManyToOne
    @JsonIgnore
    private  LevelAndDep levelAndDep;


}
