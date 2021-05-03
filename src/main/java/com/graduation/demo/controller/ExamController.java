package com.graduation.demo.controller;

import com.graduation.demo.Model.Answer;
import com.graduation.demo.Model.Exam;
import com.graduation.demo.service.ExamService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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





}
