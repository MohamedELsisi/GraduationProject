package com.graduation.demo.controller;

import com.graduation.demo.Model.Answer;
import com.graduation.demo.Model.Exam;
import com.graduation.demo.service.ExamService;
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
public class ExamController {
    @Autowired
    private ExamService service;

    @PostMapping("/addExam")
    @ApiOperation(value = "insert new exam",response = ResponseEntity.class)
    public ResponseEntity addExam(@RequestBody Exam exam) {
        log.info("ADD_EXAM CONTROLLER " + exam);
        Exam existingExam= service.createExam(exam);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingExam);
    }
    @PutMapping("/updateExam")
    @ApiOperation(value = "Update  exam",response = ResponseEntity.class)

    public ResponseEntity updateExam(@RequestBody Exam exam) {
        log.info("Update Exam controller with object = " + exam);
        Exam existingExam= service.updateExam(exam);
        if (existingExam == null)
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(existingExam);
        }
    }

    @GetMapping("/getAllStudentExams/{id}")
    @ApiOperation(value = "search All Student Exams  by id", response = ResponseEntity.class)
    public ResponseEntity getAllExam(@ApiParam(value = "id value for the student u need to retrieve", required = true)
            @PathVariable Long id) {
        log.info("get All Exam controller with object = " + id);
        Set<Exam> existingExam= service.getAllExams(id);
        if (existingExam == null)
            return ResponseEntity.notFound().build();
        else {
            System.out.println(existingExam);
            return ResponseEntity.ok().body(existingExam);
        }
    }


}
