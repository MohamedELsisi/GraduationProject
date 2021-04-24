package com.graduation.demo.controller;

import com.graduation.demo.Model.Department;
import com.graduation.demo.service.DepartmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl service;

    @PostMapping("/addDepartment")
    public ResponseEntity addDepartment(@RequestBody Department department) {
        log.info("Add_Department_Controller ", department);
        Department existingDepartment = service.addDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingDepartment);
    }

    @PostMapping("/addAllDepartment")
    public ResponseEntity<List<Department>> addAllDepartment(@RequestBody List<Department> departments) {
        log.info("create_List_Of_Doctor_Controller " + departments);
        List<Department> existingDepartments = service.addAllDepartment(departments);

        return ResponseEntity.ok(existingDepartments);
    }

    @GetMapping("/findDepartmentById/{id}")
    public ResponseEntity findDepartmentById(@PathVariable Long id) {
        log.info("Find Department by id in controller with id = " + id);
        Department existingDepartment = service.getDepartmentById(id);

        if (existingDepartment == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(existingDepartment);
    }

    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        log.info("Get All Doctors in controller ");
        List<Department> existingDepartment = service.getAllDepartment();
        if (existingDepartment == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(existingDepartment);
    }

    @GetMapping("/findDepartmentByName/{name}")
    public ResponseEntity findDepartmentByName(@PathVariable String name) {
        log.info("Find Department by Name in Controller with name = " + name);
        Department existingDepartment = service.getDepartmentByName(name);
        if (existingDepartment == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(existingDepartment);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity deleteDepartment(@PathVariable Long id) {
        log.info("Delete Department by id in controller with id = " + id);
        boolean status = service.deleteDepartmentById(id);
        if (status == false)
            return ResponseEntity.notFound().build();

        else
            return ResponseEntity.status(HttpStatus.FOUND).build();
    }

    @PutMapping("/updateDepartment")
    public ResponseEntity updateDepartment(Department department) {
        log.info("Update  doctor  controller with object = " + department);
        Department existingDepartment = service.updateDepartment(department);
        if (existingDepartment == null)
            return ResponseEntity.notFound().build();
        else {

            return ResponseEntity.ok(existingDepartment);
        }
    }


}
