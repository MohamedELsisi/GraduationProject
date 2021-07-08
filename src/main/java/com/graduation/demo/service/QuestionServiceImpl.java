package com.graduation.demo.service;

import com.graduation.demo.Dao.QuestionRepository;
import com.graduation.demo.Model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository repository;

    @Override
    public Question createQuestion(Question question) {
        log.info("Create_Question service with object   " + question);
        Question existingQuestion = repository.save(question);
        if (existingQuestion == null)
            log.warn("Create_Question service is null");
        else
            log.info("Create_Question service response " + existingQuestion);
        return existingQuestion;

    }

    @Override
    public Question UpdateQuestion(Question question) {
        log.info("Update_Question service with object " + question);
        Question existingQuestion = repository.findById(question.getId()).orElse(null);
        if (existingQuestion == null)
            log.warn("Update_Question service is null");
        else
            log.info("Update_Question service response " + existingQuestion);
        existingQuestion.setQuestion(question.getQuestion());
        repository.save(existingQuestion);
        return existingQuestion;
    }

    @Override
    public boolean deleteQuestion(Long id) {
        log.info("Delete_Question service with id  " + id);
        Question existingQuestion = repository.findById(id).orElse(null);
        if (existingQuestion == null) {
            log.warn("Delete_Question service is null");
            return false;
        } else {
            log.info("Delete_Question service response " + existingQuestion);
            repository.deleteById(id);
            return true;
        }
    }
}
