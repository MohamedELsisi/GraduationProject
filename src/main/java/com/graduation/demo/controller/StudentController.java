package com.graduation.demo.controller;

import com.graduation.demo.Model.Course;
import com.graduation.demo.Model.Student;
import com.graduation.demo.dto.DoctorReportForCourseAndExam;
import com.graduation.demo.dto.StudentAndExamForCourseDto;
import com.graduation.demo.service.StudentServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentServiceImpl service;

    @PostMapping("/addStudent")
    @ApiOperation(value = "insert new Student ", response = ResponseEntity.class)

    public ResponseEntity addCourse(@RequestBody Student student) {
        log.info("ADD_STUDENT CONTROLLER " + student);
        Student existingStudent = service.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingStudent);
    }

    @PostMapping("/addAllStudents")
    @ApiOperation(value = "insert List of students ", response = ResponseEntity.class)

    public ResponseEntity<List<Student>> addAllStudent(@RequestBody List<Student> students) {
        log.info("ADD ALL STUDENT CONTROLLER " + students);
        List<Student> existingStudents = service.addAllStudents(students);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingStudents);
    }

    @GetMapping("/findStudentById/{id}")
    @ApiOperation(value = "search about student by id ", response = ResponseEntity.class)

    public ResponseEntity findStudentById(@ApiParam(value = "id value for the Student u need to retrieve", required = true)
                                          @PathVariable Long id) {
        log.info("Find Student by id in controller with id = " + id);
        Student existingStudent = service.getStudentById(id);

        if (existingStudent == null) return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(existingStudent);
    }

    @GetMapping("/getAllStudents")
    @ApiOperation(value = "Show All Student ", response = ResponseEntity.class)

    public ResponseEntity<List<Student>> getAllStudents() {
        log.info("Get All Students in controller ");
        List<Student> existingStudents = service.getAllStudents();
        if (existingStudents == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(existingStudents);
    }

    @GetMapping("/findStudentByName/{name}")
    @ApiOperation(value = "Search about Student by name ", response = ResponseEntity.class)

    public ResponseEntity findStudentByName(@ApiParam(value = "Name value for the student u need to retrieve", required = true)
                                            @PathVariable String name) {
        log.info("Find Student by Name in Controller with name = " + name);
        Student existingStudent = service.getStudentByName(name);
        if (existingStudent == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(existingStudent);
    }

    @GetMapping("/findStudentByEmail/{email}")
    @ApiOperation(value = "Search about Student by email ", response = ResponseEntity.class)
    public ResponseEntity findStudentByEmil(@ApiParam(value = "email value for the student u need to retrieve", required = true)
                                            @PathVariable String email) {
        log.info("Find Student by email in Controller with email = " + email);
        Student existingStudent = service.getStudentByEmail(email);
        if (existingStudent == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(existingStudent);
    }


    @DeleteMapping("/deleteStudent/{id}")
    @ApiOperation(value = "delete student by id ", response = ResponseEntity.class)

    public ResponseEntity deleteStudent(@ApiParam(value = "id value for the student u need to delete", required = true)
                                        @PathVariable Long id) {
        log.info("Delete Course by id in controller with id = " + id);
        boolean status = service.deleteStudentById(id);
        if (status == false)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/updateStudent")
    @ApiOperation(value = "Update student", response = ResponseEntity.class)
    public ResponseEntity updateStudent(Student student) {
        log.info("Update  Course controller with object = " + student);
        Student existingStudent = service.updateStudent(student);
        if (existingStudent == null)
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(existingStudent);
        }
    }

    @GetMapping("/findStudentsByCourse/{id}")
    @ApiOperation(value = "search about student by id ", response = ResponseEntity.class)

    public ResponseEntity findStudentsByCourseId(@ApiParam(value = "id value for the Student u need to retrieve", required = true)
                                          @PathVariable Long id) {
        log.info("Find Student by id in controller with id = " + id);
        List<DoctorReportForCourseAndExam> existingStudent = service.getAllStudentAtCourseId(id);

        if (existingStudent == null) return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(existingStudent);
    }
}
