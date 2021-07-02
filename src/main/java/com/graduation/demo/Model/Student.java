package com.graduation.demo.Model;

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
@ApiModel(description = "Details about the Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(notes = "The unique id of the Student")
    private Long id;

    @ApiModelProperty(notes = "The Name of the Student")
    private String name;

    @ApiModelProperty(notes = "The address of Student")
    private String address;

    @ApiModelProperty(notes = "The phone number of Student")
    private String phone;

    @ApiModelProperty(notes = "The user name of Student")
    private  String userName;

    @ApiModelProperty(notes = "The password of Student")
    private  String password;

    @ApiModelProperty(notes = "The email of Student")
    private String email ;

    @ApiModelProperty(notes = "The type Student")
    private static  String type ="student";


    @OneToMany(mappedBy = "students")
    private Set<StudentAndCourse> studentAndCourse;



@ManyToOne
@JoinColumn( name = "levai_Dep_id",referencedColumnName = "id")
    private LevelAndDep levelAndDep;


}
