package com.graduation.demo.dto;



import lombok.Data;

import java.util.List;

@Data
public class StudentAnswerForCourseFlowchartDTO {

    private List<String> examName;
    private List<Integer> passedDegree;
    private List<Integer> unPassedDegree;

}
