package com.graduation.demo.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "Details about the Login ")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique id of the Login")
    private Long  loginId;

    @Column(unique = true)
    @ApiModelProperty(notes = "The user name ")
    private String userName ;
    @ApiModelProperty(notes = "The user password ")
    private  String password;
    @ApiModelProperty(notes = "The user email ")
    private String email;
    @ApiModelProperty(notes = "The user email ")
    private  String type;

    private Long id;

}
