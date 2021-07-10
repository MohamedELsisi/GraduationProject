package com.graduation.demo.dto;

import lombok.Data;

@Data
public class StudentAnswerForCourseTableDTO{

    private String examName;
    private String doctorName;
    private String date;
    private int studentDegree;
    private int examDegree;
    private boolean status;

}