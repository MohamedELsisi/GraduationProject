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
@ApiModel(description = "Details about the Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(notes = "The unique id of the Doctor")
    private Long id;

    @ApiModelProperty(notes = "The name of Doctor")
    private String name;

    @ApiModelProperty(notes = "The phone number of Doctor")
    private String phone;

    @ApiModelProperty(notes = "The address of doctor")
    private String address;

    @ApiModelProperty(notes = "The user name of doctor")
    private String userName;

    @ApiModelProperty(notes = "The password of doctor")
    private String password;

    @ApiModelProperty(notes = "The email of doctor")
    private String email;

    @ApiModelProperty(notes = "The type doctor")
    private static String type = "doctor";

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Course> course;
}
