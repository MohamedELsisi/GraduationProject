package com.graduation.demo.controller;

import com.graduation.demo.Model.Answer;
import com.graduation.demo.service.AnswerService;
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
public class AnswerController {
    @Autowired
    private AnswerService service;

    @PostMapping("/addAnswer")
    @ApiOperation(value = "insert answer", response = ResponseEntity.class)
    public ResponseEntity addAnswer(@RequestBody Answer answer) {
        log.info("ADD_Answer CONTROLLER " + answer);
        Answer existingAnswer = service.createAnswer(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingAnswer);
    }

    @PutMapping("/updateAnswer")
    @ApiOperation(value = "update  the answer", response = ResponseEntity.class)
    public ResponseEntity updateAnswer(@RequestBody Answer answer) {
        log.info("Update Answer controller with object = " + answer);
        Answer existingAnswer = service.UpdateAnswer(answer);
        if (existingAnswer == null)
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(existingAnswer);
        }
    }


    @GetMapping("/getAllStudentAnswers/{id}")
    @ApiOperation(value = "Show All Student Answers ", response = ResponseEntity.class)
    public ResponseEntity<List<Answer>> getAllStudentAnswers(@ApiParam(value = "id value for the Department u need to retrieve", required = true)
                                                             @PathVariable Long id) {
        log.info("Get All student Answers  in controller with id = " + id);
        List<Answer> existAnswer = service.getAllStudentAnswers(id);
        if (existAnswer == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(existAnswer);
    }


    @GetMapping("/getAllStudentAnswersInExam/{id}/{exam_id}")
    @ApiOperation(value = "Show All Student Answers ", response = ResponseEntity.class)
    public ResponseEntity<List<Answer>> getAllStudentAnswersInExam(@ApiParam(value = "id value for the student u need to retrieve", required = true)
                                                             @PathVariable Long id ,@PathVariable Long exam_id) {
        log.info("Get All student Answers  in controller with id = " + id + "  "+ exam_id);
        List<Answer> existAnswer = service.getAllByExamAndStudentId(id,exam_id);
        if (existAnswer == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(existAnswer);
    }

    @GetMapping("/getAllStudentAnswersInExam/{id}/{course_id}")
    @ApiOperation(value = "Show All Student Answers ", response = ResponseEntity.class)
    public ResponseEntity<List<Answer>> getAllByStudentAndCourseId(@ApiParam(value = "id value for the student u need to retrieve", required = true)
                                                                   @PathVariable Long id ,@PathVariable Long course_id) {
        log.info("Get All student Answers  in controller with id = " + id + "  "+ course_id);
        List<Answer> existAnswer = service.getAllByStudentAndCourseId(id,course_id);
        if (existAnswer == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(existAnswer);
    }

    @DeleteMapping("/deleteAnswer/{id}")
    @ApiOperation(value = "delete the answer with id ", response = ResponseEntity.class)
    public ResponseEntity deleteAnswer(@ApiParam(value = "id value for the answer u need to delete", required = true)
                                       @PathVariable Long id) {
        log.info("Delete Answer by id in controller with id = " + id);
        boolean status = service.deleteAnswer(id);
        if (status == false)
            return ResponseEntity.notFound().build();

        else
            return ResponseEntity.status(HttpStatus.FOUND).build();
    }


}
