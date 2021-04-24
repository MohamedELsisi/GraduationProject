package com.graduation.demo.controller;

import com.graduation.demo.Model.Course;
import com.graduation.demo.Model.Student;
import com.graduation.demo.service.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class StudentController {
    @Autowired
    private StudentServiceImpl service;

    @PostMapping("/addStudent")
    public ResponseEntity addCourse(@RequestBody Student student) {
        log.info("ADD_STUDENT CONTROLLER " + student);
        Student existingStudent = service.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingStudent);
    }

    @PostMapping("/addAllStudents")
    public ResponseEntity<List<Student>> addAllCourses(@RequestBody List<Student> students) {
        log.info("ADD ALL STUDENT CONTROLLER " + students);
        List<Student> existingStudents = service.addAllStudents(students);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingStudents);
    }

    @GetMapping("/findStudentById/{id}")
    public ResponseEntity findStudentById(@PathVariable Long id) {
        log.info("Find Student by id in controller with id = " + id);
        Student existingStudent = service.getStudentById(id);

        if (existingStudent == null) return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(existingStudent);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        log.info("Get All Students in controller ");
        List<Student> existingStudents = service.getAllStudents();
        if (existingStudents == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(existingStudents);
    }

    @GetMapping("/findStudentByName/{name}")
    public ResponseEntity findStudentByName(@PathVariable String name) {
        log.info("Find Student by Name in Controller with name = " + name);
        Student existingStudent = service.getStudentByName(name);
        if ( existingStudent== null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(existingStudent);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity deleteStudent(@PathVariable  Long id) {
        log.info("Delete Course by id in controller with id = " + id);
        boolean status = service.deleteStudentById(id);
        if (status == false)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).build();
    }

    @PutMapping("/updateStudent")
    public ResponseEntity updateStudent(Student student) {
        log.info("Update  Course controller with object = " + student);
        Student existingStudent = service.updateStudent(student);
        if (existingStudent == null)
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(existingStudent);
        }
    }


}
