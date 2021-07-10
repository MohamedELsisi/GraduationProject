package com.graduation.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentAnswerForCourseDTO {

   private List<StudentAnswerForCourseTableDTO> CourseTableDTO;

    private StudentAnswerForCourseFlowchartDTO courseFlowchartDTO;

}
