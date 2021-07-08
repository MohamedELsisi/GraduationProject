package com.graduation.demo.service;

import com.graduation.demo.Model.Department;
import com.graduation.demo.Model.Doctor;

import java.util.List;

public interface DepartmentService {
    public Department addDepartment (Department department);
    public List<Department> addAllDepartment(List<Department> departments);
    public Department getDepartmentById(Long id);
    public List<Department> getAllDepartment();
    public Department getDepartmentByName(String name);
    public boolean deleteDepartmentById(Long id);
    public Department updateDepartment(Department department);

}
