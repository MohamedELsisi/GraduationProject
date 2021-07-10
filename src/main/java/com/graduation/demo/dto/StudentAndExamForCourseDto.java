package com.graduation.demo.dto;

import com.graduation.demo.Model.Exam;
import com.graduation.demo.Model.LevelAndDep;
import lombok.Data;

@Data
public class StudentAndExamForCourseDto {

    private Long id;

    private String name;

    private String address;

    private String phone;

    private  String userName;

    private  String password;

    private String email ;

    private LevelAndDep level_Dep_id;

    private Long exam_id;


}
