package com.graduation.demo.service;

import com.graduation.demo.Model.Question;

public interface QuestionService {
    public Question createQuestion(Question question);
    public  Question UpdateQuestion(Question question);
    public  boolean deleteQuestion(Long Id);

}
