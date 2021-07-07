package com.graduation.demo.dto;

import com.graduation.demo.Model.Department;
import com.graduation.demo.Model.Level;
import lombok.Data;

import java.util.List;

@Data
public class AssignDepartment {

    private Department department;
    private List<Level> levels;

}
