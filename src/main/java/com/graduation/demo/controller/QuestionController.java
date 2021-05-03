package com.graduation.demo.controller;

import com.graduation.demo.Model.Answer;
import com.graduation.demo.Model.Course;
import com.graduation.demo.Model.Question;
import com.graduation.demo.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @PostMapping("/addQuestion")
    @ApiOperation(value = "insert new Question ", response = ResponseEntity.class)

    public ResponseEntity addQuestion(@RequestBody Question question) {
        log.info("ADD_QUESTION CONTROLLER " + question);
        Question existingQuestion = service.createQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingQuestion);
    }


    @PutMapping("/updateQuestion")
    @ApiOperation(value = "Update The Question", response = ResponseEntity.class)

    public ResponseEntity updateQuestion(@RequestBody Question question) {
        log.info("Update  Question controller with object = " + question);
        Question existingQuestion = service.UpdateQuestion(question);
        if (existingQuestion == null)
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(existingQuestion);
        }
    }

    @DeleteMapping("/deleteQuestion/{id}")
    @ApiOperation(value = "Delete The Question by id ", response = ResponseEntity.class)

    public ResponseEntity deleteQuestion(@ApiParam(value = "id value for the Question u need to delete", required = true)
                                             @PathVariable  Long id) {
        log.info("Delete Question by id in controller with id = " + id);
        boolean status = service.deleteQuestion(id);
        if (status == false)
            return ResponseEntity.notFound().build();

        else
            return ResponseEntity.status(HttpStatus.FOUND).build();
    }
}
