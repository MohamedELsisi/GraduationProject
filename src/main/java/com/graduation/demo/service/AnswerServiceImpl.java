package com.graduation.demo.service;

import com.graduation.demo.Dao.AnswerRepository;
import com.graduation.demo.Model.Answer;
import com.graduation.demo.Model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    private AnswerRepository repository;

    @Override
    public Answer createAnswer(Answer answer) {
        log.info("Create_Answer service with object   " + answer);
        Answer existingAnswer = repository.save(answer);
        if (existingAnswer == null)
            log.warn("Create_Answer service is null");
        else
            log.info("Create_Answer service response " + existingAnswer);
        return existingAnswer;

    }

    @Override
    public Answer UpdateAnswer(Answer answer) {
        log.info("Update_Answer service with object " + answer);
        Answer existingAnswer  = repository.findById(answer.getId()).orElse(null);
        if (existingAnswer == null)
            log.warn("Update_Answer service is null");
        else
            log.info("Update_Answer service response " + existingAnswer);
        existingAnswer.setAnswer(answer.getAnswer());
        repository.save(existingAnswer);
        return existingAnswer;
    }

    @Override
    public boolean deleteAnswer(Long id) {
        log.info("Delete_Answer service with id  " + id);
        Answer existingAnswer  = repository.findById(id).orElse(null);
        if (existingAnswer == null) {
            log.warn("Delete_Answer service is null");
            return false;
        } else {
            log.info("Delete_Answer service response " + existingAnswer);
            repository.deleteById(id);
            return true;
        }
    }


    @Override
    public List<Answer> getAllStudentAnswers(Long id) {
        log.info("Get All Student Answer service with id  " + id);
        List<Answer> existingAnswers =repository.getAllByStudentId(id);
        if(existingAnswers ==null)
            log.warn("Get All Student Answer service is null");
        else
            log.info("Get All Student Answer service response"+existingAnswers);
        return  existingAnswers;
    }

    @Override
    public List<Answer> getAllByExamAndStudentId(Long stud_id, Long exam_id) {
        log.info("Get All Student Answer service with id  " + stud_id+"  "+exam_id);
        List<Answer> existingAnswers =repository.getAllByStudentAndExamId(stud_id,exam_id);
        if(existingAnswers==null)
            log.warn("get All By Exam And Student Id service is null");
        else
            log.info("get All By Exam And Student Id service response"+existingAnswers);
        return  existingAnswers;


    }

    @Override
    public List<Answer> getAllByStudentAndCourseId(Long stud_id, Long course_id) {
        log.info("Get All Student Answer service with id  " + stud_id+"  "+course_id);
        List<Answer> existingAnswers =repository.getAllByStudentAndCourseId(stud_id,course_id);
        if(existingAnswers==null)
            log.warn("get All By Exam And Student Id service is null");
        else
            log.info("get All By Exam And Student Id service response"+existingAnswers);
        return  existingAnswers;


    }
}
