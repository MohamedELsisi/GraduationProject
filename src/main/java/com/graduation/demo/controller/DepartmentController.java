package com.graduation.demo.controller;

import com.graduation.demo.Model.Department;
import com.graduation.demo.dto.AssignDepartment;
import com.graduation.demo.service.DepartmentServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl service;

    @PostMapping("/addDepartment")
    @ApiOperation(value = "insert new Department ", response = ResponseEntity.class)
    public ResponseEntity addDepartment(@RequestBody AssignDepartment assignDepartment) {
        log.info("Add_Department_Controller ", assignDepartment.getDepartment());
        Department existingDepartment = service.addDepartment(assignDepartment.getDepartment());
        assignDepartment.setDepartment(existingDepartment);
        service.assignDepartment(assignDepartment);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingDepartment);
    }

    @PostMapping("/addAllDepartment")
    @ApiOperation(value = "insert List of Departments ", response = ResponseEntity.class)
    public ResponseEntity<List<Department>> addAllDepartment(@RequestBody List<Department> departments) {
        log.info("create_List_Of_Doctor_Controller " + departments);
        List<Department> existingDepartments = service.addAllDepartment(departments);

        return ResponseEntity.ok(existingDepartments);
    }

    @GetMapping("/findDepartmentById/{id}")
    @ApiOperation(value = "search about Department by id  ", response = ResponseEntity.class)
    public ResponseEntity findDepartmentById(@ApiParam(value = "id value for the Department u need to retrieve", required = true)
                                             @PathVariable Long id) {
        log.info("Find Department by id in controller with id = " + id);
        Department existingDepartment = service.getDepartmentById(id);

        if (existingDepartment == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(existingDepartment);
    }


    @GetMapping("/getAllDepartments")
    @ApiOperation(value = "Show All  Department ", response = ResponseEntity.class)
    public ResponseEntity<List<Department>> getAllDepartments() {
        log.info("Get All Doctors in controller ");
        List<Department> existingDepartment = service.getAllDepartment();
        if (existingDepartment == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(existingDepartment);
    }

    @GetMapping("/findDepartmentByName/{name}")
    @ApiOperation(value = "search about Department by name  ", response = ResponseEntity.class)

    public ResponseEntity findDepartmentByName(@ApiParam(value = "Name value for the Department u need to retrieve", required = true)
                                               @PathVariable String name) {
        log.info("Find Department by Name in Controller with name = " + name);
        Department existingDepartment = service.getDepartmentByName(name);
        if (existingDepartment == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(existingDepartment);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    @ApiOperation(value = "Delete the Department by id ", response = ResponseEntity.class)
    public ResponseEntity deleteDepartment(@ApiParam(value = "id value for the Department u need to delete", required = true)
                                           @PathVariable Long id) {
        log.info("Delete Department by id in controller with id = " + id);
        boolean status = service.deleteDepartmentById(id);
        if (status == false)
            return ResponseEntity.notFound().build();

        else
            return ResponseEntity.status(HttpStatus.FOUND).build();
    }

    @PutMapping("/updateDepartment")
    @ApiOperation(value = "Update  the Department ", response = ResponseEntity.class)
    public ResponseEntity updateDepartment( @RequestBody Department department) {
        log.info("Update  doctor  controller with object = " + department);
        Department existingDepartment = service.updateDepartment(department);
        if (existingDepartment == null)
            return ResponseEntity.notFound().build();
        else {

            return ResponseEntity.status(HttpStatus.FOUND).body(existingDepartment);
        }
    }


}
