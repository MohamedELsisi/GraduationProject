package com.graduation.demo.dto;

import lombok.Data;

@Data
public class DoctorReportForCourseAndExam {

    private String studentName;
    private String studentPhone;
    private String examName;
    private String answerDate;
    private int studentDegree;
    private int examDegree;
    private boolean status;



}
