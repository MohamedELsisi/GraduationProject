package com.graduation.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ALlCoursesReportByStudent {

    private List<String> coursesName;
    private List<Integer> degree;
    private List<String> colors;

}
